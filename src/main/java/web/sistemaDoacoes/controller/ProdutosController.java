package web.sistemaDoacoes.controller;


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

import web.sistemaDoacoes.model.Status;
import web.sistemaDoacoes.ajax.NotificacaoAlertify;
import web.sistemaDoacoes.ajax.TipoNotificacaoAlertify;
import web.sistemaDoacoes.model.Produtos;
import web.sistemaDoacoes.repository.ProdutosRepository;
import web.sistemaDoacoes.service.ProdutosService;


@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutosController.class);
	
	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private ProdutosService produtosService;
	
	
	
	@GetMapping("/cadastrar")
	public String abrirCadastrar(Produtos produtos) {
		return "produtos/cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid Produtos produtos, BindingResult resultado) {
		if (resultado.hasErrors()) {
			for (FieldError erro : resultado.getFieldErrors()) {
				logger.info("{}", erro);
			}
			return "produtos/cadastrar";
		} else {
			produtosService.salvar(produtos);
			return "redirect:/produtos/cadastrosucesso";
		}
	}
	
	@GetMapping("/cadastrosucesso")
	public String mostrarCadastroSucesso(Produtos produtos, Model model) {
		NotificacaoAlertify notificacao = 
				new NotificacaoAlertify("Cadastro de produto efetuado com sucesso.",
						                TipoNotificacaoAlertify.SUCESSO);
		model.addAttribute("notificacao", notificacao);
		return "produtos/cadastrar";
	}
	
	@PostMapping("/confirmarremocao")
	public String confirmarRemocao(Produtos produtos) {
		return "produtos/confirmarremocao";
	}
	@PostMapping("/remover")
	public String remover(Produtos produtos) {
		produtos.setStatus(Status.INATIVO);
		produtosService.alterar(produtos);
		return "redirect:/produtos/remocaosucesso/";
	}

	
	@GetMapping("/remocaosucesso")
	public String mostrarRemocaoSucesso(Model model) {
		NotificacaoAlertify notificacao = 
				new NotificacaoAlertify("Remoção de produto efetuada com sucesso.",
						                TipoNotificacaoAlertify.SUCESSO);
		model.addAttribute("notificacao", notificacao);
		return "produtos/pesquisar";
	}
}
