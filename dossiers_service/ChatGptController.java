package com.example.dossiers_service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGptController {

    private final ChatGptService chatGptService;

    public ChatGptController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @GetMapping("/summarize")
    public String summarize(@RequestParam String text) throws InterruptedException {
        return chatGptService.getSummary(text);
    }
}
