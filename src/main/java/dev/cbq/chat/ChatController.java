package dev.cbq.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/chats")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask-pdf")
    public String chat() {
        return chatClient.prompt()
                .user("How did the Federal Reserve's recent interest rate cut impact various asset classes according to the analysis")
                .call()
                .content();
    }
}