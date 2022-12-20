package web.sistemaDoacoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import web.sistemaDoacoes.model.Usuario;
import web.sistemaDoacoes.model.Papel;

@Entity
@Table (name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5757384541654785800L;
	@Id
	@SequenceGenerator(name = "gerador3", sequenceName = "usuario_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador3", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String login;
	private String senha;
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	private boolean ativo;
	@ManyToMany
	@JoinTable(name = "usuario_papel", joinColumns = @JoinColumn(name = "codigo_usuario"), inverseJoinColumns = @JoinColumn(name = "codigo_papel"))
	private List<Papel> papeis = new ArrayList<>();
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	@Override
	public String toString() {
		return "id: " + id + "\nlogin:" + login + "\nsenha=" + senha;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( id, login, senha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
