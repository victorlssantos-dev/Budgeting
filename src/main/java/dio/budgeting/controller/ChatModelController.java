package dio.budgeting.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Getter
@Setter
@RequiredArgsConstructor
public class ChatModelController {
    private final GoogleGenAiChatModel genAiChatModel;

    @GetMapping("/chat-model")
    String chatM(String prompt) {
        return genAiChatModel.call(prompt);
    }
}
