package com.ai.setup.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final Client client;
    private final String model;

    public ChatService(
            @Value("${gemini.api-key}") String apiKey,
            @Value("${gemini.model}") String model) {

        this.model = model;
        this.client = Client.builder()
                .apiKey(apiKey)
                .build();
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
