package com.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Empresa;
import com.model.Filtro;
import com.model.Funcionarios;
import com.model.Imovel;
import com.model.Proprietario;

@RestController
public class ControllerGeral {

	@GetMapping("/listarTodos")
	public List<Imovel> ListarTodosImoveis(){
		List<Imovel> imoveis = serviceGeral.ListarTodosImoveis();
		return imoveis;
	}
	
	@GetMapping("/listarImoveisProprietario/{Id}")
	public List<Imovel> ListarImoveisProprietario(@PathVariable long ProprietarioId){
		List<Imovel> imoveis = serviceGeral.ListarImoveisProprietario(ProprietarioId);
		return imoveis;
	}
	
	@GetMapping("/listarImoveisFiltro/")
	public List<Imovel> ListarImoveisProprietario(@RequestBody Filtro filtro){
		List<Imovel> imoveis = serviceGeral.ListarImoveisProprietario(filtro);
		return imoveis;
	}
	
	
	@GetMapping("/listarImoveisPesquisa/{Titulo}")
	public List<Imovel> ListarImoveisPesquisa(@PathVariable String Pesquisa){
		List<Imovel> imoveis = serviceGeral.ListarImoveisPesquisa(Pesquisa);
		return imoveis;
	}
	
	
	@GetMapping("/listarImoveisPorRelevancia")
	public List<Imovel> ListarImoveisPorRelevancia(){
		List<Imovel> imoveis = serviceGeral.ListarImoveisPorRelevancia();
		return imoveis;
	}
	
	@GetMapping("/listarImoveisPorTipo/{Tipo}")
	public List<Imovel> ListarImoveisPorTipo(@PathVariable String Tipo){
		List<Imovel> imoveis = serviceGeral.ListarImoveisPorTipo(Tipo);
		return imoveis;
	}
	
	@GetMapping("/listarImoveisMaiorPreco")
	public List<Imovel> ListarImoveisMaiorPreco(){
		List<Imovel> imoveis = serviceGeral.ListarImoveisMaiorPreco();
		return imoveis;
	}
	
	@GetMapping("/listarImoveisMenorPreco")
	public List<Imovel> ListarImoveisMenorPreco(){
		List<Imovel> imoveis = serviceGeral.ListarImoveisMenorPreco();
		return imoveis;
	}

	@GetMapping("/listarEmpresas")
	public List<Empresa> ListarEmpresas(){
		List<Empresa> empresas = serviceGeral.ListarEmpresas();
		return empresas;
	}
	

	@GetMapping("/listarFuncionarios")
	public List<Funcionarios> ListarFuncionarios(){
		List<Funcionarios> funcionarios = serviceGeral.ListarFuncionarios();
		return funcionarios;
	}

	@GetMapping("/detalharImovel")
	public Imovel DetalharImovel(){
		Imovel imovel = serviceGeral.DetalharImovel();
		return imovel;
	}
	
	@GetMapping("/detalharEmpresa")
	public Empresa DetalharEmpresa(){
		Empresa empresa = serviceGeral.DetalharEmpresa();
		return empresa;
	}
	
	@GetMapping("/detalharFuncionario")
	public Funcionarios DetalharFuncionario(){
		Funcionarios funcionario = serviceGeral.DetalharFuncionario();
		return funcionario;
	}
	
	@GetMapping("/detalharProprietario")
	public Proprietario DetalharProprietario(){
		Proprietario proprietario = serviceGeral.DetalharProprietario();
		return proprietario;
	}
	
	
	
	
	
	
}
