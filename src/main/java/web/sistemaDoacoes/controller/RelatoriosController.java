package web.sistemaDoacoes.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.sistemaDoacoes.service.RelatorioService;



@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {

	private static final Logger logger = LoggerFactory.getLogger(RelatoriosController.class);
	
	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping("/Produtos")
	public ResponseEntity<byte[]> gerarRelatorioCarro() {
		
		byte[] relatorio = relatorioService.gerarRelatorioSimplesCarros();
		
		logger.debug("Relatório simples");
		logger.debug("Retornando o relatório simples");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Relatorio.pdf")
				.body(relatorio);
	}
	
	
}