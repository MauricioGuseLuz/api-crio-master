package com.crio.api.repository;

import com.crio.api.domain.Endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    @Query("SELECT e FROM Endereco e WHERE e.cidade = :cidade")
    List<Endereco> findByCidade(String cidade);

    @Query("SELECT e FROM Endereco e WHERE e.uf = :uf")
    List<Endereco> findByUf(String uf);
}
