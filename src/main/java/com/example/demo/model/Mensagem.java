package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mensagem{
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private String id;
	private String mensagem;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Usuario emissor;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Usuario receptor;
	private Date dataDeEnvio;
}
