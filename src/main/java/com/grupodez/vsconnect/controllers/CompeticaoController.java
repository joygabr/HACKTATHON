package com.grupodez.vsconnect.controllers;

import com.grupodez.vsconnect.models.CompeticaoModel;
import com.grupodez.vsconnect.repositories.CompeticaoRepository;
import dtos.CompeticaoDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/competicao", produces = {"application/json"})
public class CompeticaoController {
    @Autowired
    CompeticaoRepository repository;

    @GetMapping
    public ResponseEntity<List<CompeticaoModel>> listarcompeticao(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }
    @GetMapping("/{idCompeticao}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable(value = "idCompeticao") UUID id){
        Optional<CompeticaoModel> competicaoBuscado = repository.findById(id);

        if(competicaoBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competidor nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(competicaoBuscado.get());
    }

    @RequestMapping
    @PostMapping
    public ResponseEntity<Object> criarUsuario(@ModelAttribute @Valid CompeticaoDto competicaoDto){

        CompeticaoModel competicaoModel = new CompeticaoModel();
        BeanUtils.copyProperties(competicaoDto, competicaoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(competicaoModel));
    }
}
