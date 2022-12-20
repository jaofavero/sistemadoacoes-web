package web.sistemaDoacoes.model;


import java.io.Serializable; 
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "doacao")
@DynamicUpdate
public class Doacao implements Serializable{
	private static final long serialVersionUID = -3935828642122652510L;
	@Id
	@SequenceGenerator(name = "gerador2", sequenceName = "doacao_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador2", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	@NotNull(message = "A quantidade de produtos é obrigatória")
	@Positive(message = "A quantidade de produtos deve ser maior que zero 0")
	private int quantidade;
	@ManyToOne
	@JoinColumn(name = "doador_id")
	private Doador doador;
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produtos produtos;
	
	
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Doador getDoador() {
		return doador;
	}
	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	public void setVacina(Produtos Produtos) {
		this.produtos = Produtos;
	}
	@Override
	public String toString() {
		return "codigo:" + codigo + "\nquantidade:" + quantidade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, doador, produtos, quantidade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doacao other = (Doacao) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(doador, other.doador)
				&& Objects.equals(produtos, other.produtos) && quantidade == other.quantidade;
	}

	
		
}