package web.sistemaDoacoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.sistemaDoacoes.model.Doador;
import web.sistemaDoacoes.repository.DoadorRepository;
import web.sistemaDoacoes.service.DoadorService;


@Controller
@RequestMapping("/doador")
public class DoadorController {
	
	private static final Logger logger = LoggerFactory.getLogger(DoadorController.class);
	@Autowired
	private DoadorRepository doadorRepository;
	
	@Autowired
	private DoadorService doadorService;
	
	
	@GetMapping("/cadastrar")
	public String abrirCadastro(Doador doador) {
		return "pessoa/cadastrar";
	}


	
	@PostMapping("/cadastrar")
	public String cadastrar(@Valid Doador doador, BindingResult resultado) {
		if (resultado.hasErrors()) {
			for (FieldError erro : resultado.getFieldErrors()) {
			}
			return "pessoa/cadastrar";
		} else {
			doadorService.salvar(doador);
			return "redirect:/pessoas/cadastro/sucesso";
		}
	}
	
	@GetMapping("/cadastro/sucesso")
	public String mostrarMensagemCadastroSucesso(Model model) {
		model.addAttribute("mensagem", "Cadastro de Doador efetuado com sucesso.");
		return "mostrarmensagem";
	}
	@PostMapping("/abriralterar")
	public String abrirAlterar(Doador doador) {
		return "doador/alterar";
	}
	
	
	@PostMapping("/alterar")
	public String alterar(@Valid Doador doador, BindingResult resultado) {
		if (resultado.hasErrors()) {
			for (FieldError erro : resultado.getFieldErrors()) {
			}
			return "doador/alterar";
		} else {
			doadorService.alterar(doador);
			return "redirect:/doador/alterar/sucesso";
		}
	}
	
	@GetMapping("/alterar/sucesso")
	public String mostrarMensagemAlterarSucesso(Model model) {
		model.addAttribute("mensagem", "Alteração do Pessoa efetuada com sucesso.");
		return "mostrarmensagem";
	}
	
	
}
