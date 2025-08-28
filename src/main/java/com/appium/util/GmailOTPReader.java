package com.appium.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailOTPReader {

    private static final String APPLICATION_NAME = "Gmail OTP Reader";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "src/main/resources/credentials.json"; // or env-based path

    private Gmail service;

    public GmailOTPReader() throws Exception {
        this.service = new Gmail.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                getCredentials()
        ).setApplicationName(APPLICATION_NAME).build();
    }

    private static Credential getCredentials() throws IOException, GeneralSecurityException {
        InputStream in;

        // For CI/CD: read base64 secret from env
        String encoded = System.getenv("GMAIL_CREDENTIALS_B64");
        if (encoded != null && !encoded.isEmpty()) {
            byte[] decoded = Base64.getDecoder().decode(encoded);
            in = new ByteArrayInputStream(decoded);
        } else {
            // Local development: read credentials.json
            File file = new File(CREDENTIALS_FILE_PATH);
            if (!file.exists()) throw new FileNotFoundException("File not found: " + CREDENTIALS_FILE_PATH);
            in = new FileInputStream(file);
        }

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                clientSecrets,
                SCOPES
        ).setAccessType("offline").build();

        // LocalServerReceiver handles OAuth flow in a browser for local; headless in CI/CD
        LocalServerReceiver receiver = new LocalServerReceiver.Builder()
                .setPort(8888)  // or any free port
                .build();

        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public String getLatestOTP() throws IOException {
        ListMessagesResponse messagesResponse = service.users().messages().list("me")
                .setQ("subject:OTP")
                .setMaxResults(1L)
                .execute();

        List<Message> messages = messagesResponse.getMessages();
        if (messages == null || messages.isEmpty()) return null;

        Message message = service.users().messages().get("me", messages.get(0).getId()).execute();
        String body = getMessageBody(message);

        Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(body);
        return matcher.find() ? matcher.group() : null;
    }

    private String getMessageBody(Message message) {
        MessagePart part = message.getPayload();
        if (part.getParts() != null && !part.getParts().isEmpty()) {
            for (MessagePart p : part.getParts()) {
                if ("text/plain".equals(p.getMimeType())) {
                    return decodeBody(p.getBody().getData());
                }
            }
        }
        return decodeBody(part.getBody().getData());
    }

    private String decodeBody(String body) {
        return new String(Base64.getUrlDecoder().decode(body));
    }
}
