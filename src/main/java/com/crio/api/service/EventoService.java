package com.crio.api.service;

import com.crio.api.domain.Evento.Evento;
import com.crio.api.domain.Evento.EventoResquestDTO;
import com.crio.api.domain.Evento.IntervaloDataDTO;
import com.crio.api.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Evento createEvento(EventoResquestDTO data) {
        Evento newEvento = new Evento();
        newEvento.setTitulo(data.titulo());
        newEvento.setDescricao(data.descricao());
        newEvento.setDataInicio(data.dataInicio());
        newEvento.setDataFim(data.dataFim());
        newEvento.setEventoPrivado(data.eventoPrivado());
        newEvento.setLocal(data.local());
        newEvento.setUsuario(data.usuario());
        newEvento.setLinkEvento(data.linkEvento());
        newEvento.setComoChegar(data.comoChegar());
        newEvento.setLinkForms(data.linkForms());
        eventoRepository.save(newEvento);
        return newEvento;
    }

    public List<Evento> getAllUsers() {
        return eventoRepository.findAll();
    }

    public Evento getUserByid(UUID id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

    }

    public Evento updateUser(UUID id, EventoResquestDTO eventoResquestDTO) {
        Evento updateEvento = getUserByid(id);
        updateEvento.setTitulo(eventoResquestDTO.titulo());
        updateEvento.setDescricao(eventoResquestDTO.descricao());
        updateEvento.setDataInicio(eventoResquestDTO.dataInicio());
        updateEvento.setDataFim(eventoResquestDTO.dataFim());
        updateEvento.setEventoPrivado(eventoResquestDTO.eventoPrivado());
        updateEvento.setLocal(eventoResquestDTO.local());
        updateEvento.setUsuario(eventoResquestDTO.usuario());
        updateEvento.setUpdateAt(LocalDateTime.now());

        return eventoRepository.save(updateEvento);
    }

    public void deleteUser(UUID id) {
        Evento evento = getUserByid(id);
        eventoRepository.delete(evento);
    }

    public List<Evento> findByUsuarioId(UUID usuarioId) {
        return eventoRepository.findByUsuarioId(usuarioId);
    }

    public List<Evento> findByIntervaloData(IntervaloDataDTO intervaloDataDTO) {
        LocalDateTime inicio = intervaloDataDTO.inicio();
        LocalDateTime fim = intervaloDataDTO.fim();
        return eventoRepository.findByIntervaloData(inicio, fim);
    }
    public List<Evento> findByLocal(String local){
        return eventoRepository.findByLocal(local);
    }
    public List<Evento> findByLocalAndIntervaloData(String local, LocalDateTime inicio, LocalDateTime fim){
        return eventoRepository.findByLocalAndIntervaloData(local,inicio,fim);
    }
}
