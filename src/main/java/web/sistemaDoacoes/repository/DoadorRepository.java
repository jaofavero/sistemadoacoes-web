package web.sistemaDoacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.sistemaDoacoes.model.Doador;


public interface DoadorRepository extends JpaRepository<Doador, Long> {

}
