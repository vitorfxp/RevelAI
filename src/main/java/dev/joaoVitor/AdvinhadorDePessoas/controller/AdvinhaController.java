package dev.joaoVitor.AdvinhadorDePessoas.controller;


import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaDTO;
import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaModel;
import dev.joaoVitor.AdvinhadorDePessoas.service.AdvinhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advinha")
public class AdvinhaController {

    private final AdvinhaService advinhaService;

    public AdvinhaController(AdvinhaService advinhaService) {
        this.advinhaService = advinhaService;
    }

   // POST
    public ResponseEntity<AdvinhaDTO> criar(@RequestBody AdvinhaDTO advinhaDTO){
        AdvinhaDTO salvo = advinhaService.salvar(advinhaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(salvo);
    }

    // CRIAR TODOS OS OUTROS METÓDOS, TEM QUE CONFIGURAR O BANCO, OU SEJA, NÃO DA PARA TESTAR!!




}
