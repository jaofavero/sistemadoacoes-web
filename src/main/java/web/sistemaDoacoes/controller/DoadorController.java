package web.sistemaDoacoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import web.sistemaDoacoes.model.Doador;
import web.sistemaDoacoes.repository.DoadorRepository;
import web.sistemaDoacoes.service.DoadorService;



public class DoadorController {
	
	
	@Autowired
	private DoadorRepository doadorRepository;
	
	@Autowired
	private DoadorService doadorService;
	
	
	@GetMapping("/cadastrar")
	public String abrirCadastro(Doador doador) {
		return "pessoa/cadastrar";
	}


	
	@PostMapping("/cadastrar")
	public String cadastrar(@Valid Doador doador) {
		if (doador.hasErrors()) {
			for (FieldError erro : doador.getFieldErrors()) {
			}
			return "pessoa/cadastrar";
		} else {
			doadorService.salvar(doador);
			return "/pessoas/";
		}
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Doador doador, BindingResult resultado) {
		if (resultado.hasErrors()) {
			for (FieldError erro : resultado.getFieldErrors()) {
			}
			return "pessoa/alterar";
		} else {
			doadorService.alterar(doador);
			return "/pessoas/";
		}
	}
	
	
}
