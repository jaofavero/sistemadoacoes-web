package web.sistemaDoacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.sistemaDoacoes.model.Doacao;



public interface DoacaoRepository extends JpaRepository<Doacao, Long>{

}
