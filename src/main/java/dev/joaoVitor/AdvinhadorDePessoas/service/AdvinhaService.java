package dev.joaoVitor.AdvinhadorDePessoas.service;

import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaDTO;
import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaMapper;
import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaModel;
import dev.joaoVitor.AdvinhadorDePessoas.repository.AdvinhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<AdvinhaDTO> listar(){
        List<AdvinhaModel> lista = advinhaRepository.findAll();
        return lista.stream().map(advinhaMapper::map).collect(Collectors.toList());
    }

    public AdvinhaDTO listarPorId(Long id){
        Optional<AdvinhaModel> itemId = advinhaRepository.findById(id);
        return itemId.map(advinhaMapper::map).orElse(null);
    }

    public AdvinhaDTO atualizar(AdvinhaDTO advinhaDTO, Long id){
        Optional<AdvinhaModel> item_existe = advinhaRepository.findById(id);
        if(item_existe.isPresent()){
            AdvinhaModel item_atualizado = advinhaMapper.map(advinhaDTO);
            item_atualizado.setId(id);
            item_atualizado = advinhaRepository.save(item_atualizado);
            return advinhaMapper.map(item_atualizado);
        }
        return null;
    }

    public String deletar(Long id) {
       Optional<AdvinhaModel> item = advinhaRepository.findById(id);
       if(item.isPresent()){
           advinhaRepository.deleteById(id);
           return "O item foi deletado";
       }

       return null;
    }


}
