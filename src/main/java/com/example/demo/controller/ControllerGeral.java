package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.dto.FuncionariosDTO;
import com.example.demo.dto.ImovelDTO;
import com.example.demo.dto.ProprietarioDTO;
import com.example.demo.model.Filtro;
import com.example.demo.service.ServiceGeral;

@RestController
public class ControllerGeral {
	@Autowired
	ServiceGeral serviceGeral;

	@GetMapping("/listarTodos")
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

	@GetMapping("/listarEmpresas")
	public ResponseEntity<List<EmpresaDTO>> ListarEmpresas(){
		List<EmpresaDTO> empresas = serviceGeral.ListarEmpresas();
		return new ResponseEntity<>(empresas, HttpStatus.OK);
	}
	

	@GetMapping("/listarFuncionarios")
	public ResponseEntity<List<FuncionariosDTO>> ListarFuncionarios(){
		List<FuncionariosDTO> funcionarios = serviceGeral.ListarFuncionarios();
		return new ResponseEntity<>(funcionarios, HttpStatus.OK);
	}

	@GetMapping("/detalharImovel")
	public ResponseEntity<ImovelDTO> DetalharImovel(){
		ImovelDTO imovel = serviceGeral.DetalharImovel();
		return new ResponseEntity<>(imovel, HttpStatus.OK);
	}
	
	@GetMapping("/detalharEmpresa")
	public ResponseEntity<EmpresaDTO> DetalharEmpresa(){
		EmpresaDTO empresa = serviceGeral.DetalharEmpresa();
		return new ResponseEntity<>(empresa, HttpStatus.OK);
	}
	
	@GetMapping("/detalharFuncionario")
	public ResponseEntity<FuncionariosDTO> DetalharFuncionario(){
		FuncionariosDTO funcionario = serviceGeral.DetalharFuncionario();
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}
	
	@GetMapping("/detalharProprietario")
	public ResponseEntity<ProprietarioDTO> DetalharProprietario(){
		ProprietarioDTO proprietario = serviceGeral.DetalharProprietario();
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}
	
	
}
