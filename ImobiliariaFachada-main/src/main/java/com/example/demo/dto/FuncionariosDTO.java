package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Empresa;
import com.example.demo.model.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {
    private String userId;
	private String usuario;
	private List<Mensagem> mensagensEnviadas;
	private List<Mensagem> mensagensRecebidas;
	private String email;
	private String telefone;
	private byte[] foto;
    private String creci;
	private Empresa empresa;
}
