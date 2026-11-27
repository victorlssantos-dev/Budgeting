package dio.budgeting;

import com.google.genai.Client;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Builder
@EnabledIfEnvironmentVariable(named = "GEMINI_API_KEY", matches = ".+")
public class GeminiAiChatModelIT {

    @Autowired
    Client genAiClient;

    @Test
    void deve_receberResposta_quando_chatModelForChamado() {
        var options = GoogleGenAiChatOptions.builder()
                .model("gemini-2.5-flash")
                .temperature(0.5)
                .responseMimeType("text/plain")
                .build();

        var chatModel = GoogleGenAiChatModel.builder()
                .genAiClient(genAiClient)
                .options(options)
                .build();

        var response = chatModel.call("Gere um registro de budgeting, co descrição de gasto, valor em Reais e Local");
        System.out.println(response);
        assertThat(response).isNotBlank();
    }
}