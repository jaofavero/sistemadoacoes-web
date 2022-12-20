package web.sistemaDoacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.sistemaDoacoes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNomeUsuarioIgnoreCase(String nomeUsuario);
	
}
