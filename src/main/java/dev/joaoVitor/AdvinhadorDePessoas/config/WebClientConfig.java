package dev.joaoVitor.AdvinhadorDePessoas.config;

// https://api.openai.com/v1/responses => recomendação do chatgpt
// https://api.openai.com/v1/chat/completions => utilizado no projeto

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${chatgpt.api.url:https://api.openai.com/v1/chat/completions/API_KEY}")
    private String chatGpt_url;

    @Bean // e para da contexto
    private WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(chatGpt_url).build();
    }


}
