package web.sistemaDoacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.sistemaDoacoes.model.Status;
import web.sistemaDoacoes.model.Produtos;

public interface ProdutosRepository  extends JpaRepository<Produtos, Long> {
	List<Produtos> findByNomeContainingIgnoreCase(String nome);
	List<Produtos>  findByStatus(Status status);
}
