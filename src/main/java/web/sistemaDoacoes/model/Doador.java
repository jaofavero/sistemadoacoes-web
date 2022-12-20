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
import org.springframework.validation.FieldError;

import web.sistemaDoacoes.model.Status;

@Entity
@Table(name = "doador")
@DynamicUpdate 
public class Doador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "gerador1", sequenceName = "doador_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador1", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	private String nome;
	private String telefone;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "codigo: " + codigo + "\nnome: " + nome + "\ntelefone: " + telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doador other = (Doador) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
}
