package web.sistemaDoacoes.ajax;

public enum TipoNotificacaoAlertify {
	
	SUCESSO("success"),
	ERRO("error"),
	WARNING("warning"),
	MENSAGEM("message");
	
	private String tipo;
	
	private TipoNotificacaoAlertify(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}	
}