package web.sistemaDoacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.sistemaDoacoes.model.Doador;
import web.sistemaDoacoes.model.Status;


public interface DoadorRepository extends JpaRepository<Doador, Long> {

	List<Doador> findByStatus(Status ativo);

}
