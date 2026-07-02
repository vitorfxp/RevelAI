package dev.joaoVitor.AdvinhadorDePessoas.config;

// https://api.openai.com/v1/responses => recomendação do chatgpt
// https://api.openai.com/v1/chat/completions => utilizado no projeto

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${chatgpt.api.url:https://generativelanguage.googleapis.com}")
    private String gemini_url;

    @Bean // e para da contexto
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(gemini_url).build();
    }
}
