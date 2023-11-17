package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ImovelDTO;
import com.example.demo.dto.ProprietarioDTO;
import com.example.demo.model.Imovel;
import com.example.demo.model.Proprietario;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.ImovelRepository;
import com.example.demo.repository.MensagemRepository;
import com.example.demo.repository.ProprietarioRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class ServiceGeral {
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Proprietario CriarProprietario(ProprietarioDTO proprietarioDTO){
        Proprietario proprietario = new ModelMapper().map(proprietarioDTO, Proprietario.class);
          proprietario = proprietarioRepository.save(proprietario);
        return proprietario;
    }

    public Imovel CriarImovel(ImovelDTO imovelDTO){
        ModelMapper modelMapper = new ModelMapper();
        Imovel imovel = modelMapper.map(imovelDTO, Imovel.class);
            imovel = imovelRepository.save(imovel);
        return imovel;
        
    }

    public List<ImovelDTO> ListarTodosImoveis(){
        List<Imovel> listaDeImoveis = imovelRepository.findAll();
        List<ImovelDTO> listaDeImoveisDTO = listaDeImoveis.stream()
            .map(i -> new ModelMapper().map(i, ImovelDTO.class))
            .collect(Collectors.toList());
            return listaDeImoveisDTO;
            }
            
    }

