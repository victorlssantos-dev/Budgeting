package dio.budgeting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatClientController {

    private final ChatClient chatClient;

    @GetMapping("/chat")
    String chat(String prompt) {return chatClient.prompt().user(prompt).call().content();}

}
