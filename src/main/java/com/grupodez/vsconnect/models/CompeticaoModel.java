package com.grupodez.vsconnect.models;

import dtos.CompeticaoDto;
import dtos.DadosAtualizacaoCompeticao;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_competicao")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CompeticaoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_competicao", nullable = false)
    private UUID id;

    private String nome;
    private String modalidade;
    private String presenca;

    public CompeticaoModel(CompeticaoDto dados){
        this.nome = dados.nome();
        this.modalidade = dados.modalidade();
        this.presenca = dados.presenca();
    }

    public void atualizarInformacoes(DadosAtualizacaoCompeticao dados){
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.modalidade() != null) {
            this.modalidade = dados.modalidade();
        }
        if (dados.presenca() != null) {
            this.presenca = dados.presenca();
        }
    }
}
