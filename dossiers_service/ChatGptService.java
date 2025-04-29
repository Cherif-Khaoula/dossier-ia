package com.example.dossiers_service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class ChatGptService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public ChatGptService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getSummary(String text) throws InterruptedException {
        String url = "https://api.openai.com/v1/chat/completions";

        // Configurer les en-têtes
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        // Créer la requête JSON pour demander un résumé
        String jsonBody = "{\n" +
                "\"model\": \"gpt-4o-mini\",\n" +
                "\"messages\": [\n" +
                "{\"role\": \"system\", \"content\": \"Vous êtes un assistant utile qui résume les textes.\",\n" +
                "\"role\": \"user\", \"content\": \"Peux-tu résumer ce texte : " + text + "\"}\n" +
                "]\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);


        // Effectuer la requête POST
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        try {
            // Faire la requête API
            restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (HttpClientErrorException.TooManyRequests e) {
            // Gérer l'erreur 429, par exemple avec un message d'erreur
            System.out.println("Quota dépassé, veuillez réessayer plus tard.");
            // Ou mettre en place un délai d'attente avant de refaire la requête
            Thread.sleep(60000); // Attendre 1 minute avant de réessayer
        }
        return response.getBody();
    }
}
