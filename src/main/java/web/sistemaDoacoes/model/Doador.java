package web.sistemaDoacoes.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.validation.FieldError;

@Entity
@Table(name = "doador")
public class Doador {
	
	@Id
	@SequenceGenerator(name = "gerador1", sequenceName = "doador_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador1", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String telefone;
	
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "id: " + id + "\nnome: " + nome + "\ntelefone: " + telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, telefone);
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
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
	public boolean hasErrors() {
		// TODO Auto-generated method stub
		return false;
	}
	public FieldError[] getFieldErrors() {
		// TODO Auto-generated method stub
		return null;
	}	
}
