package br.com.study.fornecedor.repository;

import br.com.study.fornecedor.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

    Info findByEstado(String estado);

}
