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
import com.example.demo.service.FuncionariosService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
    @Autowired
    FuncionariosService funcionariosService;

	@GetMapping("/listarFuncionarios")
	public ResponseEntity<List<FuncionariosDTO>> ListarFuncionarios(){
		List<FuncionariosDTO> funcionarios = funcionariosService.ListarFuncionarios();
		return new ResponseEntity<>(funcionarios, HttpStatus.OK);
	}
	
	@GetMapping("/detalharFuncionario")
	public ResponseEntity<FuncionariosDTO> DetalharFuncionario(){
		FuncionariosDTO funcionario = funcionariosService.DetalharFuncionario();
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}

    @PostMapping("/criarFuncionario/{idEmpresa}")
    public ResponseEntity<FuncionariosDTO> criarFuncionario(@RequestBody FuncionariosDTO funcionariosDTO, @PathVariable long idEmpresa){
        funcionariosDTO = funcionariosService.criarFuncionario(funcionariosDTO, idEmpresa);
        return new ResponseEntity<>(funcionariosDTO, HttpStatus.CREATED);
    }
	
	@PutMapping("/adicionarFuncionarioParaEmpresa")
	public ResponseEntity<EmpresaDTO> AdicionarFuncionarioParaEmpresa(@RequestBody EmpresaDTO empresa){
		empresa = funcionariosService.AdicionarFuncionarioParaEmpresa();
		return new ResponseEntity<>(empresa, HttpStatus.OK);
	}

}