package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO {
    private String id;
	private String mensagem;
	private Usuario emissor;
	private Usuario receptor;
	private Date dataDeEnvio;
}
