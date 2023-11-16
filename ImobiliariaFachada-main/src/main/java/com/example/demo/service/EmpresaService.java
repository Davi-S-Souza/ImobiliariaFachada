
package com.example.demo.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.exception.ResourceBadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Empresa;
import com.example.demo.repository.EmpresaRepository;


@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaDTO criarEmpresa(EmpresaDTO empresaDTO){
        Optional<Empresa> empresaOpt = empresaRepository.findById(empresaDTO.getCnpj());
        if(!empresaOpt.isEmpty()){
            throw new ResourceBadRequestException("Esta empresa ja esta registrada!");
        }
        Empresa empresa = new ModelMapper().map(empresaDTO, Empresa.class);
        empresaRepository.save(empresa);
        return empresaDTO;
    }

    public EmpresaDTO alterarEmpresa(EmpresaDTO empresaDTO, String empresaId){
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada!"));
        empresa = new ModelMapper().map(empresaDTO, Empresa.class);
        empresaRepository.save(empresa);
        return empresaDTO;
    }
            
    }

