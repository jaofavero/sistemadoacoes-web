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
	private Long codigo;
	private String nome;
	private String senha;
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	private boolean ativo;
	@ManyToMany
	@JoinTable(name = "usuario_papel", joinColumns = @JoinColumn(name = "codigo_usuario"), inverseJoinColumns = @JoinColumn(name = "codigo_papel"))
	private List<Papel> papeis = new ArrayList<>();
	
	
	

	
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
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

	
	@Override
	public String toString() {
		return "codigo:" + codigo + "\nnome:" + nome + "\nsenha:" + senha + "\nnomeUsuario:" + nomeUsuario;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ativo, codigo, nome, nomeUsuario, papeis, senha);
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
		return ativo == other.ativo && Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeUsuario, other.nomeUsuario) && Objects.equals(papeis, other.papeis)
				&& Objects.equals(senha, other.senha);
	}
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public void adicionarPapel(Papel papel) {
		papeis.add(papel);
	}

	public void removerPapel(Papel papel) {
		papeis.remove(papel);
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	
	
}
