package com.crio.api.controller;

import com.crio.api.domain.Usuario.Usuario;
import com.crio.api.domain.Usuario.UsuarioRequestDTO;
import com.crio.api.repository.UsuarioRepository;
import com.crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    //CRUD
//    @PostMapping("/save")//api/usuario/save
//    public Usuario save(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
//        return usuarioService.save(
//                usuarioRequestDTO.nomeCompleto(),
//                usuarioRequestDTO.email(),
//                usuarioRequestDTO.senha(),
//                usuarioRequestDTO.tipo(),
//                LocalDateTime.now(),
//                LocalDateTime.now());
//
//    }


    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Usuario> create(
            @RequestParam("nomeCompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo) {
        UsuarioRequestDTO usuarioRequestDTO =
                new UsuarioRequestDTO(nomeCompleto, email, senha, tipo);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(newUsuario);


    }

    //Retornar todos usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> usuarios = this.usuarioService.getAllUsers();
        //retorna a lista com todos os usuarios
        return ResponseEntity.ok(usuarios);
    }

    //Retorna o usuario pelo id
    @GetMapping("/{id}") // /api/usuario/cb886c61-9805-463a-a33b-586401c05a8f
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") UUID id) {
        Usuario usuario = this.usuarioService.getUserByid(id);
        return ResponseEntity.ok(usuario);
    }

    //Atualizar od dados do usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") UUID id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario updateUsuario = this.usuarioService.updateUser(id, usuarioRequestDTO);
        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id) {
        this.usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<Usuario>> findByEmail(@PathVariable("email") String email) {
        Optional<Usuario> usuario = this.usuarioService.findByEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{tipo}") // /api/usuario/cb886c61-9805-463a-a33b-586401c05a8f
    public ResponseEntity<List<Usuario>> findByTipo(@PathVariable("tipo") int tipo) {
        List<Usuario> usuario = this.usuarioService.findByTipo(tipo);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/cadastro")
    public List<Usuario> getUsuariosByDataCadastro(
            @RequestParam("createAt") LocalDateTime dataInicio,
            @RequestParam("dataFim") LocalDateTime dataFim) {
        return usuarioService.findUsuariosByDataCadastro(dataInicio, dataFim);
    }
}

