package dev.joaoVitor.AdvinhadorDePessoas.model;

import org.springframework.stereotype.Component;

@Component
public class AdvinhaMapper {

    public AdvinhaModel map(AdvinhaDTO advinhaDTO){
        AdvinhaModel advinhaModel = new AdvinhaModel();
        advinhaModel.setId(advinhaDTO.getId());
        advinhaModel.setDescricao(advinhaDTO.getDescricao());
        advinhaModel.setAltura(advinhaDTO.getAltura());
        advinhaModel.setPeso(advinhaDTO.getPeso());
        advinhaModel.setIdade(advinhaDTO.getIdade());
        advinhaModel.setNacionalidade(advinhaDTO.getNacionalidade());
        advinhaModel.setCaracteristicas(advinhaDTO.getCaracteristicas());

        return advinhaModel;
    }

    public AdvinhaDTO map(AdvinhaModel advinhaModel){
        AdvinhaDTO advinhaDTO = new AdvinhaDTO();
        advinhaDTO.setId(advinhaModel.getId());
        advinhaDTO.setDescricao(advinhaModel.getDescricao());
        advinhaDTO.setAltura(advinhaModel.getAltura());
        advinhaDTO.setPeso(advinhaModel.getPeso());
        advinhaDTO.setIdade(advinhaModel.getIdade());
        advinhaDTO.setNacionalidade(advinhaModel.getNacionalidade());
        advinhaDTO.setCaracteristicas(advinhaModel.getCaracteristicas());

        return advinhaDTO;
    }

}
