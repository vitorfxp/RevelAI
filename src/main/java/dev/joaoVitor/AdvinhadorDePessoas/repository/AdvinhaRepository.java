package dev.joaoVitor.AdvinhadorDePessoas.repository;

import dev.joaoVitor.AdvinhadorDePessoas.model.AdvinhaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvinhaRepository extends JpaRepository<AdvinhaModel, Long> {
}
