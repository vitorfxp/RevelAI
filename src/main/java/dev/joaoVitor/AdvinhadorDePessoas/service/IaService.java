package dev.joaoVitor.AdvinhadorDePessoas.service;

import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class IaService {

    private final WebClient webClient;
    private String api_key = System.getenv("GEMINI_API_KEY");

    public IaService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> advinharPessoa(AdvinhaDTO advinha) {

        String prompt = "Baseado nos dados de uma determinado pessoa no meu banco de dados quero que você tente aadvinhar qual ela seria e depois quero que você me fale quem de acordo com as características:\n"+ advinha;

        System.out.println(prompt);

        Map<String, Object> requestBody = Map.of(
                "agent", "antigravity-preview-05-2026",
                "input", List.of(
                        Map.of(
                                "type", "text",
                                "text", prompt
                        )
                ),
                "environment", Map.of(
                        "type", "remote"
                )
        );

        return webClient.post()
                .uri("/v1beta/interactions")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("x-goog-api-key", api_key)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var steps = (List<Map<String, Object>>) response.get("steps");

                    Map<String, Object> modelOutput = steps.stream()
                            .filter(s -> "model_output".equals(s.get("type")))
                            .findFirst()
                            .orElseThrow();

                    var content = (List<Map<String, Object>>) modelOutput.get("content");

                    return (String) content.get(0).get("text");
                })
                .doOnError(WebClientResponseException.class, e -> {
                    System.out.println("Status: " + e.getStatusCode());
                    System.out.println("Resposta: " + e.getResponseBodyAsString());
                });
    }


}
