package dev.joaoVitor.AdvinhadorDePessoas.controller;


import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaDTO;
import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaModel;
import dev.joaoVitor.AdvinhadorDePessoas.service.AdvinhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advinha")
public class AdvinhaController {

    private final AdvinhaService advinhaService;

    public AdvinhaController(AdvinhaService advinhaService) {
        this.advinhaService = advinhaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<AdvinhaDTO> criar(@RequestBody AdvinhaDTO advinhaDTO){
        AdvinhaDTO salvo = advinhaService.salvar(advinhaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AdvinhaDTO>> listar(){
        List<AdvinhaDTO> corpo = advinhaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(corpo);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> lerItemPorId(@PathVariable Long id){
        AdvinhaDTO item_id = advinhaService.listarPorId(id);

        if(item_id != null){
            return ResponseEntity.ok(item_id);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O item não foi encontrado.");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody AdvinhaDTO advinhaDTO){
        if(advinhaService.listarPorId(id) != null){
            AdvinhaDTO item_atualizado = advinhaService.atualizar(id, advinhaDTO);
            return ResponseEntity.ok("Item atualizado");
        }
        return null;
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        if (advinhaService.listarPorId(id) != null) {
            advinhaService.deletar(id);
            return ResponseEntity.ok("O item foi excluído com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O item não foi encontrado");

    }
}
