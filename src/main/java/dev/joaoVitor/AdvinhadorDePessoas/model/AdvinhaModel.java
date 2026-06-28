package dev.joaoVitor.AdvinhadorDePessoas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_advinha")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdvinhaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descricao;
    private Integer altura;
    private Integer peso;
    private Integer idade;
    private String caracteristicas;
    private String nacionalidade;

}
