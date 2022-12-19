package web.sistemaDoacoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.sistemaDoacoes.model.Doacao;
import web.sistemaDoacoes.repository.DoacaoRepository;




@Service
public class DoacaoService {

	@Autowired
	private DoacaoRepository doacaoRepository;
	
	@Transactional
	public void salvar(Doacao doacao) {
		doacaoRepository.save(doacao);
	}
	
	@Transactional
	public void alterar(Doacao doacao) {
		doacaoRepository.save(doacao);
	}
	
	@Transactional
	public void remover(Long codigo) {
		doacaoRepository.deleteById(codigo);
	}
	
	
	
}
