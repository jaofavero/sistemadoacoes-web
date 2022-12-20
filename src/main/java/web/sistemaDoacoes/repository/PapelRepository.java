package web.sistemaDoacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.sistemaDoacoes.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
}