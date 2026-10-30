package com.ai.setup.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    @Value("${gemini.api-key}")
    private String apiKey;

    @Value("${gemini.model}")
    private String model;

    private Client client;

    @PostConstruct
    public void init() {

        log.info("Initializing Gemini client...");
        log.info("Gemini model: {}", model);

        String maskedKey = apiKey.length() > 8
                ? apiKey.substring(0, 4) + "****" + apiKey.substring(apiKey.length() - 4)
                : "****";

        log.info("Gemini API key: {}", maskedKey);

        try {
            client = Client.builder()
                    .apiKey(apiKey)
                    .build();

            GenerateContentResponse response =
                    client.models.generateContent(
                            model,
                            "Reply only with OK",
                            null
                    );

            log.info("✅ Gemini connection successful");
            log.info("✅ Test response: {}", response.text());

        } catch (Exception e) {
            log.error("❌ Gemini validation failed", e);
            throw new IllegalStateException(
                    "Gemini API key or model configuration is invalid",
                    e
            );
        }
    }

    public String ask(String question) {

        GenerateContentResponse response =
                client.models.generateContent(
                        model,
                        question,
                        null
                );

        return response.text();
    }
}
