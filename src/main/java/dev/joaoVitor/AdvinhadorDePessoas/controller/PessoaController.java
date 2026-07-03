package dev.joaoVitor.AdvinhadorDePessoas.controller;


import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaDTO;
import dev.joaoVitor.AdvinhadorDePessoas.service.AdvinhaService;
import dev.joaoVitor.AdvinhadorDePessoas.service.IaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class PessoaController {

    private AdvinhaService advinhaService;
    private IaService iaService;

    public PessoaController(AdvinhaService advinhaService, IaService iaService) {
        this.advinhaService = advinhaService;
        this.iaService = iaService;
    }

    @GetMapping("/advinhou")
    public Mono<ResponseEntity<String>> advinharPessoa(){
        List<Long> ids = advinhaService.listar().stream().map(item -> item.getId()).toList();

        if (ids.isEmpty()) {
            return Mono.just(ResponseEntity.noContent().build());
        }

        AdvinhaDTO advinha = advinhaService.listarPorId(ids.get(0));
        return iaService.advinharPessoa(advinha)
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
