package com.appium.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
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
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailOTPReader {

    private static final String APPLICATION_NAME = "Gmail OTP Reader";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private Gmail service;

    public GmailOTPReader() throws Exception {
        this.service = new Gmail.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                getCredentials()
        ).setApplicationName(APPLICATION_NAME).build();
    }

    private static Properties loadConfig() throws IOException {
        Properties props = new Properties();
        String encoded = System.getenv("GMAIL_CONFIG_B64");

        if (encoded != null && !encoded.isEmpty()) {
            // CI/CD: decode base64 secret
            byte[] decoded = Base64.getDecoder().decode(encoded);
            props.load(new ByteArrayInputStream(decoded));
        } else {
            // Local: read config.properties
            try (InputStream in = new FileInputStream("src/main/resources/config.properties")) {
                props.load(in);
            }
        }
        return props;
    }

    private static Credential getCredentials() throws Exception {
        Properties props = loadConfig();

        String clientId = props.getProperty("gmail.client_id");
        String clientSecret = props.getProperty("gmail.client_secret");
        String refreshToken = props.getProperty("gmail.refresh_token");

        if (clientId == null || clientSecret == null || refreshToken == null) {
            throw new IllegalStateException("Missing CLIENT_ID, CLIENT_SECRET, or REFRESH_TOKEN in config");
        }

        return new GoogleCredential.Builder()
                .setClientSecrets(clientId, clientSecret)
                .setTransport(GoogleNetHttpTransport.newTrustedTransport())
                .setJsonFactory(JSON_FACTORY)
                .build()
                .setRefreshToken(refreshToken)
                .createScoped(Collections.singleton(GmailScopes.GMAIL_READONLY));
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
