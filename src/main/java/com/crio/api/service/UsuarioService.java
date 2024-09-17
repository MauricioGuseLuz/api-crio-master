package com.crio.api.service;

import com.crio.api.domain.Usuario.Usuario;
import com.crio.api.domain.Usuario.UsuarioRequestDTO;
import com.crio.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(UsuarioRequestDTO data) {
        Usuario newUsuario = new Usuario();
        newUsuario.setNomeCompleto(data.nomeCompleto());
        newUsuario.setEmail(data.email());
        newUsuario.setSenha(data.senha());
        newUsuario.setTipo(data.tipo());
        usuarioRepository.save(newUsuario);
        return newUsuario;
    }
//    //save usuario
//    public Usuario save(String nomeCompleto, String email, String senha, int tipo,
//            LocalDateTime createAt, LocalDateTime updateAt){
//    return usuarioRepository.saveUsuario(nomeCompleto, email, senha, tipo, createAt, updateAt);


    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserByid(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

    }

    public Usuario updateUser(UUID id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario updateUsuario = getUserByid(id);
        updateUsuario.setNomeCompleto(usuarioRequestDTO.nomeCompleto());
        updateUsuario.setEmail(usuarioRequestDTO.email());
        updateUsuario.setSenha(usuarioRequestDTO.senha());
        updateUsuario.setTipo(usuarioRequestDTO.tipo());
        updateUsuario.setUpdateAt(LocalDateTime.now());

        return usuarioRepository.save(updateUsuario);
    }

    public void deleteUser(UUID id) {
        Usuario usuario = getUserByid(id);
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> findByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }

    public List<Usuario> findByTipo(int tipo) {
        List<Usuario> usuario = usuarioRepository.findByTipo(tipo);
        return usuario;
    }
    public List<Usuario> findUsuariosByDataCadastro(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List <Usuario> usuarios = usuarioRepository.findByDataCadastro(dataInicio, dataFim);
        return usuarios;
    }
}

