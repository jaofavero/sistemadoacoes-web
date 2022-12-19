package web.sistemaDoacoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.sistemaDoacoes.model.Produtos;
import web.sistemaDoacoes.repository.ProdutosRepository;


@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Transactional
	public void salvar(Produtos produtos) {
		produtosRepository.save(produtos);
	}
	
	@Transactional
	public void alterar(Produtos produtos) {
		produtosRepository.save(produtos);
	}
	
	@Transactional
	public void remover(Long codigo) {
		produtosRepository.deleteById(codigo);
	}
	
}
