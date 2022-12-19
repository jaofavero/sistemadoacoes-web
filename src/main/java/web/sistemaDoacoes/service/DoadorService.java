package web.sistemaDoacoes.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.sistemaDoacoes.model.Doador;
import web.sistemaDoacoes.repository.DoadorRepository;



@Service
public class DoadorService {
	@Autowired
	private DoadorRepository doadorRepository;
	
	@Transactional
	public void salvar(Doador doador) {
		doadorRepository.save(doador);
	}
	
	@Transactional
	public void alterar(Doador doador) {
		doadorRepository.save(doador);
	}
	
	@Transactional
	public void remover(Long codigo) {
		doadorRepository.deleteById(codigo);
	}
	
}
