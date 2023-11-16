package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.dto.FuncionariosDTO;
import com.example.demo.dto.ImovelDTO;
import com.example.demo.dto.ProprietarioDTO;
import com.example.demo.model.Empresa;
import com.example.demo.model.Filtro;
import com.example.demo.model.Proprietario;
import com.example.demo.service.ImovelService;



@RestController
@RequestMapping("/imovel")
public class ImovelController {
    @Autowired
	ImovelService serviceGeral;

	@GetMapping("/listarTodosImoveis")
	public ResponseEntity<List<ImovelDTO>> ListarTodosImoveis(){
		List<ImovelDTO> imoveis = serviceGeral.ListarTodosImoveis();
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	@GetMapping("/listarImoveisProprietario/{Id}")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisProprietario(@PathVariable long ProprietarioId){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisProprietario(ProprietarioId);
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	@GetMapping("/listarImoveisFiltro/")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisProprietario(@RequestBody Filtro filtro){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisProprietario(filtro);
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	
	@GetMapping("/listarImoveisPesquisa/{Titulo}")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisPesquisa(@PathVariable String Pesquisa){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisPesquisa(Pesquisa);
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	
	@GetMapping("/listarImoveisPorRelevancia")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisPorRelevancia(){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisPorRelevancia();
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	@GetMapping("/listarImoveisPorTipo/{Tipo}")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisPorTipo(@PathVariable String Tipo){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisPorTipo(Tipo);
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	@GetMapping("/listarImoveisMaiorPreco")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisMaiorPreco(){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisMaiorPreco();
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}
	
	@GetMapping("/listarImoveisMenorPreco")
	public ResponseEntity<List<ImovelDTO>> ListarImoveisMenorPreco(){
		List<ImovelDTO> imoveis = serviceGeral.ListarImoveisMenorPreco();
		return new ResponseEntity<>(imoveis, HttpStatus.OK);
	}

    @GetMapping("/detalharImovel")
	public ResponseEntity<ImovelDTO> DetalharImovel(){
		ImovelDTO imovel = serviceGeral.DetalharImovel();
		return new ResponseEntity<>(imovel, HttpStatus.OK);
	}

    @PostMapping("/criarImovel")
	public ResponseEntity<ImovelDTO> CriarProprietario(@RequestBody ImovelDTO imovel){
		 imovel = serviceGeral.CriarProprietario();
		return new ResponseEntity<>(imovel, HttpStatus.OK);
	}

    @PutMapping("/alterarImovel")
	public ResponseEntity<ImovelDTO> AlterarImovel(@RequestBody ImovelDTO imovel){
		 imovel = serviceGeral.AlterarImovel();
		return new ResponseEntity<>(imovel, HttpStatus.OK);
	}

    @DeleteMapping("/deletarImovel")
	public ResponseEntity<ProprietarioDTO> DeletarImovel(@RequestBody ImovelDTO imovel){
		 imovel = serviceGeral.DeletarImovel();
		return new ResponseEntity<>(imovel, HttpStatus.OK);
	}

    @PutMapping("/adicionarImovelParaProprietario")
	public ResponseEntity<ProprietarioDTO> AdicionarImovelParaProprietario(@RequestBody ProprietarioDTO proprietario){
		 proprietario = serviceGeral.AdicionarImovelParaProprietario();
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}

	@PutMapping("/removerImovelDeProprietario")
	public ResponseEntity<ProprietarioDTO> RemoverImovelDeProprietario(@RequestBody ProprietarioDTO proprietario){
		 proprietario = serviceGeral.RemoverImovelDeProprietario();
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}
}