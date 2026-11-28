package dio.budgeting;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@EnabledIfEnvironmentVariable(named = "GEMINI_API_KEY", matches = ".+")
public class GeminiAiChatClientIT {
    @Autowired
    GoogleGenAiChatModel googleGenAiChatModel;

    @Test
    void deve_executarSom_pelo_prompt() {
        var chatSystem = SystemMessage.builder()
                .text("Voce é um matematico")
                .build();

        var chatUser = UserMessage.builder()
                .text("some 10 + 20 * 123, exiba o resultado no final sem exlicações")
                .build();
        var resposta = googleGenAiChatModel.call(chatSystem, chatUser);

        assertThat(resposta).contains("2470");
        System.out.println(resposta);
    }
}
