package com.crio.api.controller;

import com.crio.api.domain.Endereco.Endereco;
import com.crio.api.domain.Evento.Evento;
import com.crio.api.domain.Evento.EventoResquestDTO;
import com.crio.api.domain.Evento.IntervaloDataDTO;
import com.crio.api.domain.Evento.LocalIntervaloDTO;
import com.crio.api.domain.Usuario.Usuario;
import com.crio.api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//21b36628-6383-46a6-ba91-0a9360cf5f0f


@RestController
    @RequestMapping("/api/evento")
    public class EventoController {
    @Autowired
    private EventoService eventoService;

    //querys
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Evento>> findByUsuarioId(@PathVariable UUID usuario){
        List<Evento> eventos = eventoService.findByUsuarioId(usuario);
        return ResponseEntity.ok(eventos);
    }
    @PostMapping("/intervalo")
    public ResponseEntity<List<Evento>> FindByIntervaloData(@RequestBody IntervaloDataDTO intervaloDataDTO){
        List<Evento> eventos = eventoService.findByIntervaloData(intervaloDataDTO);
        return ResponseEntity.ok(eventos);
    }
    //buscar evento por local
    @GetMapping("/local/{local}")
    public ResponseEntity<List<Evento>> findByLocal(
            @PathVariable String local){
        List<Evento> eventos = eventoService.findByLocal(local);
        return ResponseEntity.ok(eventos);
    }
    @PostMapping("/local-intervalo")
    public ResponseEntity<List<Evento>> findByLocalAndIntervaloData(
            @RequestBody LocalIntervaloDTO localIntervaloDTO){
        List<Evento> eventos = eventoService.findByLocalAndIntervaloData(
                localIntervaloDTO.local(),
                localIntervaloDTO.inicio(),
                localIntervaloDTO.fim());
                return  ResponseEntity.ok(eventos);


    }



    //CRUD
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Evento> create(
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("dataInicio") LocalDateTime dataInicio,
            @RequestParam("dataFim") LocalDateTime dataFIm,
            @RequestParam("eventoPrivado") boolean eventoPrivado,
            @RequestParam("local") String local,
            @RequestParam("usuario") Usuario usuario,
            @RequestParam("linkEvento") String linkEvento,
            @RequestParam("comoChegar") String comoChegar,
            @RequestParam("linkForms") String linkForms,
            @RequestParam("endereco") Endereco endereco){
        EventoResquestDTO eventoResquestDTO =
        new EventoResquestDTO(titulo, descricao, dataInicio, dataFIm, eventoPrivado, local, usuario, linkEvento, comoChegar, linkForms, endereco);
        Evento newEvento = this.eventoService.createEvento(eventoResquestDTO);
        return ResponseEntity.ok(newEvento);


    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllUsers() {
        List<Evento> eventos = this.eventoService.getAllUsers();
        //retorna a lista com todos os usuarios
        return ResponseEntity.ok(eventos);

    }

    @GetMapping("/{id}") // /api/usuario/cb886c61-9805-463a-a33b-586401c05a8f
    public ResponseEntity<Evento> getUserById(@PathVariable("id") UUID id) {
        Evento evento = this.eventoService.getUserByid(id);
        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateUser(@PathVariable("id") UUID id, EventoResquestDTO eventoResquestDTO) {
        Evento updateEvento = this.eventoService.updateUser(id, eventoResquestDTO);
        return ResponseEntity.ok(updateEvento);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id) {
        this.eventoService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
