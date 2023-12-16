package com.grupodez.vsconnect.controllers;

import com.grupodez.vsconnect.models.CompeticaoModel;
import com.grupodez.vsconnect.repositories.CompeticaoRepository;
import dtos.CompeticaoDto;
import dtos.DadosAtualizacaoCompeticao;
import dtos.DadosListagemCompeticao;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CompeticaoDto dados) {
        repository.save(new CompeticaoModel(dados));
        return ResponseEntity.ok(dados);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCompeticao dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemCompeticao(medico));
    }


}
