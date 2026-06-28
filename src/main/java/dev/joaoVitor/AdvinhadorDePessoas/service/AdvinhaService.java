package dev.joaoVitor.AdvinhadorDePessoas.service;

import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaDTO;
import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaMapper;
import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaModel;
import dev.joaoVitor.AdvinhadorDePessoas.repository.AdvinhaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvinhaService {

    private AdvinhaRepository advinhaRepository;
    private AdvinhaMapper advinhaMapper;

    public AdvinhaService(AdvinhaRepository advinhaRepository, AdvinhaMapper advinhaMapper) {
        this.advinhaRepository = advinhaRepository;
        this.advinhaMapper = advinhaMapper;
    }

    public AdvinhaDTO salvar( AdvinhaDTO advinhaDTO){
        AdvinhaModel advinha = advinhaMapper.map(advinhaDTO);
        advinha = advinhaRepository.save(advinha);
        return advinhaMapper.map(advinha);
    }

}
