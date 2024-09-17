package com.crio.api.service;

import com.crio.api.domain.Endereco.Endereco;
import com.crio.api.domain.Endereco.EnderecoRequestDTO;
import com.crio.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco createEndereco(EnderecoRequestDTO data) {
        Endereco newEndereco = new Endereco();
        newEndereco.setCidade(data.cidade());
        newEndereco.setUf(data.uf());
        enderecoRepository.save(newEndereco);
        return newEndereco;
    }

    public List<Endereco> getAllUsers() {
        return enderecoRepository.findAll();
    }

    public Endereco getUserByid(UUID id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

    }

    public Endereco updateUser(UUID id, EnderecoRequestDTO enderecoRequestDTO) {
        Endereco updateEndereco = getUserByid(id);
        updateEndereco.setCidade(enderecoRequestDTO.cidade());
        updateEndereco.setUf(enderecoRequestDTO.uf());
        return enderecoRepository.save(updateEndereco);
    }

    public void deleteUser(UUID id) {
        Endereco endereco = getUserByid(id);
        enderecoRepository.delete(endereco);
    }
}


