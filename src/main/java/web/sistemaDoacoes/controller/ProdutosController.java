package web.sistemaDoacoes.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.sistemaDoacoes.model.Produtos;
import web.sistemaDoacoes.repository.ProdutosRepository;
import web.sistemaDoacoes.service.ProdutosService;


@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
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
			}
			return "produtos/cadastrar";
		} else {
			produtosService.salvar(produtos);
			return "produtos/cadastrar";
		}
	}

}
