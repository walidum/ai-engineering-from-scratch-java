package com.ai.setup.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatService {

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
                            "Reply with OK",
                            null
                    );

            log.info("Gemini connection successful");
            log.info("Gemini test response: {}", response.text());

        } catch (Exception e) {
            log.error("Failed to initialize Gemini client", e);
            throw new RuntimeException("Invalid Gemini configuration", e);
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
