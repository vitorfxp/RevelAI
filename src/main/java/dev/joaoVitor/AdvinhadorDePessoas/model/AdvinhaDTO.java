package dev.joaoVitor.AdvinhadorDePessoas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvinhaDTO {
    private Long id;
    private String descricao;
    private Integer altura;
    private Integer peso;
    private Integer idade;
    private String caracteristicas;
    private String nacionalidade;
}
