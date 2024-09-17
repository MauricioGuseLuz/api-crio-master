package com.crio.api.repository;

import com.crio.api.domain.Endereco.Endereco;
import com.crio.api.domain.Evento.Evento;
import com.crio.api.domain.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {
    @Query("SELECT e FROM Evento e  WHERE e.usuario.id = :usuarioId")
    List<Evento> findByUsuarioId(UUID usuarioId);

    @Query("SELECT e FROM Evento e WHERE e.dataInicio BETWEEN :inicio AND :fim")
    List<Evento> findByIntervaloData(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT e FROM Evento e WHERE e.local = :local")
    List<Evento> findByLocal(String local);
    //consulta por local e intervalo de data

    @Query("SELECT e FROM Evento e WHERE e.local = :local AND e.dataInicio BETWEEN :inicio AND :fim")
    List<Evento> findByLocalAndIntervaloData(String local, LocalDateTime inicio, LocalDateTime fim);

    //metodo para salvar usuario.
//    @Query("INSERT INTO Evento(titulo, descricao, dataInicio, dataFIm, eventoPrivado, local ," +
//    "usuario, linkEvento, comoChegar, linkForms, endereco) VALUES(:titulo,:descricao,:dataInicio,:dataFim," +
//    ":eventoPrivado,:local,:usuario,:linkEvento,:comoChegar,:linkForms,:endereco)")
//    Evento saveEvento(String titulo, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim,int eventoPrivado, String local, Usuario usuario,String linkEvento, String comoChegar, String linkForms, Endereco endereco);

    //atualizar usuario
    @Query("UPDATE Evento e SET e.titulo=:titulo, e.descricao=:descricao, e.dataInicio=:dataInicio, e.dataFim=:dataFim," +
            "e.eventoPrivado=:eventoPrivado, e.local=:local, e.usuario=:usuario, e.linkEvento=:linkEvento, e.comoChegar=:comoChegar,"+
            "e.linkForms=:linkForms, e.endereco=:endereco, e.id=:id")
    void updateUsuario(String titulo, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim,
             int eventoPrivado, String local, Usuario usuario, String linkEvento, String linkForms,
             Endereco endereco, UUID id);

    //deleter

    @Query("DELETE FROM Evento e WHERE e.id=:id")
    void deleteEvento(UUID id);


}
