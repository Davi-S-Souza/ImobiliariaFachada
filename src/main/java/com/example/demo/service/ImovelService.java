
package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ImovelDTO;
import com.example.demo.dto.ProprietarioDTO;
import com.example.demo.exception.ResourceInternalServerException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Filtro;
import com.example.demo.model.Imagens;
import com.example.demo.model.Imovel;
import com.example.demo.model.Proprietario;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.FuncionariosRepository;
import com.example.demo.repository.ImovelRepository;
import com.example.demo.repository.MensagemRepository;
import com.example.demo.repository.ProprietarioRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ProprietarioRepository proprietarioRepository;


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

    public List<ImovelDTO> ListarImovelPorProprietario(long proprietarioId){
        List<Imovel> listaDeImoveis = imovelRepository.findById(proprietarioId);
        List<ImovelDTO> listaDeImoveisDTO = listaDeImoveis.stream()
            .map(i -> new ModelMapper().map(i, ImovelDTO.class))
            .collect(Collectors.toList());
            return listaDeImoveisDTO;
            }

            
    public List<ImovelDTO> ListarImovelPorNome(String nome){
        List<Imovel> listaDeImoveis = imovelRepository.findByName(proprietarioId);
        List<ImovelDTO> listaDeImoveisDTO = listaDeImoveis.stream()
            .map(i -> new ModelMapper().map(i, ImovelDTO.class))
            .collect(Collectors.toList());
            return listaDeImoveisDTO;
            }

            
    public List<ImovelDTO> ListarImovelPorProprietario(Filtro filtro){
        List<Imovel> listaDeImoveis = imovelRepository.findByFiltro(filtro);
        List<ImovelDTO> listaDeImoveisDTO = listaDeImoveis.stream()
            .map(i -> new ModelMapper().map(i, ImovelDTO.class))
            .collect(Collectors.toList());
            return listaDeImoveisDTO;
            }

             
    public Imovel DeletarImovel(long ImovelId){
        Optional <Imovel> optionalImovel = imovelRepository.findById(ImovelId);
        if (optionalImovel.isPresent()) {
            imovelRepository.deleteById(ImovelId);
        }
    }
        
    public Proprietario AdicionarImovelParaProprietario(long proprietarioId, long ImovelId){
        Optional <Proprietario> optionalProprietario = proprietarioRepository.findById(proprietarioId);
        Optional <Imovel> optionalImovel = imovelRepository.findById(ImovelId);
        if (optionalProprietario.isPresent()) {
            if (optionalImovel.isPresent()) {
                optionalImovel.setProprietario(optionalProprietario);
            }
        }
    }

    public ImovelDTO adicionarImagens(Long imovelId, MultipartFile[] files){
        Imovel imovel = imovelRepository.findById(imovelId).orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado!"));
        try {
            List<Imagens> imagens = uploadImage(files);
            List<Imagens> imagensJaExistentes = imovel.getImagens();
            imagens.addAll(imagensJaExistentes);
            imovel.setImagens(imagens);
            imovelRepository.save(imovel);
            ImovelDTO imovelDTO = new ModelMapper().map(imovel, ImovelDTO.class);
            return imovelDTO;
        } catch (Exception e) {
            throw new ResourceInternalServerException("Ocorreu um erro no servidor!");
        }
    }

     public List<Imagens> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        List<Imagens> imagens = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            Imagens imagem = new Imagens(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imagens.add(imagem);
        }

        return imagens;
    }
            
    }

