package com.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario{
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="user_id")
	private String userId;
	private String usuario;
	@OneToMany(mappedBy="emissor")
	private List<Mensagem> mensagensEnviadas;
	@OneToMany(mappedBy="receptor")
	private List<Mensagem> mensagensRecebidas;
	private String email;
	private String telefone;
	private byte[] foto;
}