package com.crio.api.controller;

import com.crio.api.domain.Endereco.Endereco;
import com.crio.api.domain.Endereco.EnderecoRequestDTO;
import com.crio.api.domain.Usuario.Usuario;
import com.crio.api.repository.EnderecoRepository;
import com.crio.api.repository.UsuarioRepository;
import com.crio.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Endereco> create(
            @RequestParam("cidade") String cidade,
            @RequestParam("uf") String uf) {
        EnderecoRequestDTO enderecoRequestDTO =
                new EnderecoRequestDTO(cidade, uf);
        Endereco newEndereco = this.enderecoService.createEndereco(enderecoRequestDTO);
        return ResponseEntity.ok(newEndereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllUsers() {
        List<Endereco> enderecos = this.enderecoService.getAllUsers();
        //retorna a lista com todos os usuarios
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}") // /api/usuario/cb886c61-9805-463a-a33b-586401c05a8f
    public ResponseEntity<Endereco> getUserById(@PathVariable("id") UUID id) {
        Endereco endereco = this.enderecoService.getUserByid(id);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateUser(@PathVariable("id") UUID id, EnderecoRequestDTO enderecoRequestDTO) {
        Endereco updateEndereco = this.enderecoService.updateUser(id, enderecoRequestDTO);
        return ResponseEntity.ok(updateEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id) {
        this.enderecoService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}







