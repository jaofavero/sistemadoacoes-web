package web.sistemaDoacoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.sistemaDoacoes.model.Status;
import web.sistemaDoacoes.model.Doacao;
import web.sistemaDoacoes.model.Doador;
import web.sistemaDoacoes.model.Produtos;
import web.sistemaDoacoes.repository.DoacaoRepository;
import web.sistemaDoacoes.repository.DoadorRepository;
import web.sistemaDoacoes.repository.ProdutosRepository;
import web.sistemaDoacoes.service.DoacaoService;




@Controller
@RequestMapping("/doacao")
public class DoacaoController {
	private static final Logger logger = LoggerFactory.getLogger(DoacaoController.class);
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private DoadorRepository doadorRepository;

	@Autowired
	private DoacaoRepository doacaoRepository;

	@Autowired
	private DoacaoService doacaoService;
	
	@GetMapping("/cadastrar")
	public String abrirCadastrar(Doacao doacao, Model model) {
		logger.info("Entrou cadastar");
		colocarProdutosModelo(model);
		colocarDoadorModelo(model);
		return "doacao/cadastrar";
	}

	private void colocarProdutosModelo(Model model) {
		List<Produtos> produtos = produtosRepository.findByStatus(Status.ATIVO);
		model.addAttribute("produtos", produtos);
	}
	private void colocarDoadorModelo(Model model) {
		List<Doador> doador = doadorRepository.findAll();
		model.addAttribute("doador", doador);
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid Doacao doacao, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			logger.info("O lote recebido para cadastrar não é válido.");
			logger.info("Erros encontrados:");
			for (FieldError erro : resultado.getFieldErrors()) {
				logger.info("{}", erro);
			}
			colocarProdutosModelo(model);
			colocarDoadorModelo(model);
			return "doacao/cadastrar";
		} else {
			doacaoService.salvar(doacao);
			return "redirect:/doacao/cadastrosucesso";
		}
	}

	@GetMapping("/cadastrosucesso")
	public String mostrarCadastroSucesso(Model model) {
		model.addAttribute("mensagem", "Cadastro de Doação efetuado com sucesso.");
		return "mostrarmensagem";
	}
	
	
	
	@PostMapping("/alterar")
	public String alterar(@Valid Doacao doacao, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			logger.info("O lote recebido para alterar não é válido.");
			logger.info("Erros encontrados:");
			for (FieldError erro : resultado.getFieldErrors()) {
				logger.info("{}", erro);
			}
			colocarProdutosModelo(model);
			colocarDoadorModelo(model);
			return "doacao/alterar";
		} else {
			doacaoService.alterar(doacao);
			return "redirect:/doacao/alterarsucesso";
		}
	}

	@GetMapping("/alterarsucesso")
	public String mostrarAlterarSucesso(Model model) {
		model.addAttribute("mensagem", "Alteração de lote efetuada com sucesso.");
		return "mostrarmensagem";
	}

	/*@PostMapping("/confirmarremocao")
	public String confirmarRemocao(Doacao doacao) {
		return "doacao/confirmarremocao";
	}

	@PostMapping("/remover")
	public String remover(Doacao doacao) {
		doacao.setStatus(Status.INATIVO);
		doacaoService.alterar(doacao);
		return "redirect:/lotes/remocaosucesso";
	}

	@GetMapping("/remocaosucesso")
	public String mostrarRemocaoSucesso(Model model) {
		model.addAttribute("mensagem", "Remoção de lote efetuada com sucesso.");
		return "mostrarmensagem";
	}*/
	
	

}
