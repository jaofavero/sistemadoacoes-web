package web.sistemaDoacoes.model;

import java.io.Serializable;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import web.sistemaDoacoes.model.Status;

@Entity
@Table(name = "produtos")
@DynamicUpdate
public class Produtos implements Serializable {

	
	private static final long serialVersionUID = 7562368353372595992L;
	@Id
	@SequenceGenerator(name = "gerador4", sequenceName = "produto_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador4", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String observacao;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ",\nnome: " + nome + "\nobservacao:" + observacao;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(observacao, other.observacao);
	}
	
	
	
	
}
