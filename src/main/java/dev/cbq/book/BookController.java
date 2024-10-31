package dev.cbq.book;

import dev.cbq.model.BookRecommendation;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final ChatClient chatClient;

    public BookController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    public List<BookRecommendation> list() {
        return chatClient.prompt()
            .user("Generate 10 book recommendation for a book on Literature. Please limit the summary to 100 words and it is must be chinese.")
            .call()
            .entity(new ParameterizedTypeReference<>() {});
    }
}
