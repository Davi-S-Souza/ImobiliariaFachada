package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem,String>{
    
}
