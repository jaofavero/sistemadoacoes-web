package web.sistemaDoacoes.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {

	
	@Id
	@SequenceGenerator(name = "gerador3", sequenceName = "usuario_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador3", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String login;
	private String senha;
	private int cargo;	
	
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
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	
	@Override
	public String toString() {
		return "id: " + id + "\nlogin:" + login + "\nsenha=" + senha + "\ncargo=" + cargo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cargo, id, login, senha);
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
		return cargo == other.cargo && Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(senha, other.senha);
	}

	
	
	
}
