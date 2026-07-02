package dev.joaoVitor.AdvinhadorDePessoas.controller;


import dev.joaoVitor.AdvinhadorDePessoas.service.ChatGptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PessoaController {

    private ChatGptService chatGptService;

    public PessoaController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @GetMapping("/advinhou")
    public Mono<ResponseEntity<String>> advinharPessoa(){
        return chatGptService.advinharPessoa()
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
