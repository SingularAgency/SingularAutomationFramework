package com.appium.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.ModifyMessageRequest;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailOTPReader {

    private static final String APPLICATION_NAME = "Gmail OTP Reader";
    private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList("https://www.googleapis.com/auth/gmail.readonly");
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";

    private Gmail service;

    public GmailOTPReader() throws IOException, GeneralSecurityException {
        this.service = new Gmail.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                getCredentials()
        ).setApplicationName(APPLICATION_NAME).build();
    }

    public String getLatestOTP() throws IOException {
        ListMessagesResponse messagesResponse = service.users().messages().list("me")
                .setQ("subject:OTP")
                .setMaxResults(1L)
                .execute();

        List<Message> messages = messagesResponse.getMessages();

        if (messages == null || messages.isEmpty()) {
            System.out.println("No OTP emails found.");
            return null;
        }

        Message message = service.users().messages().get("me", messages.get(0).getId()).execute();
        String body = getMessageBody(message);

        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(body);

        if (matcher.find()) {
            return matcher.group();
        } else {
            System.out.println("No OTP found in message body.");
            return null;
        }
    }

    private static Credential getCredentials() throws IOException, GeneralSecurityException {
        InputStream in = GmailOTPReader.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY,
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in)),
                SCOPES
        ).setDataStoreFactory(new com.google.api.client.util.store.FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline").build();

        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    private String getMessageBody(Message message) {
        MessagePart part = message.getPayload();
        if (part.getParts() != null && !part.getParts().isEmpty()) {
            for (MessagePart p : part.getParts()) {
                if (p.getMimeType().equals("text/plain")) {
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
