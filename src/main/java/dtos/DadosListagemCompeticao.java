package dtos;

import com.grupodez.vsconnect.models.CompeticaoModel;

import java.util.UUID;

public record DadosListagemCompeticao(
        UUID id, String nome, String modalidade, String presenca
) {
    public DadosListagemCompeticao(CompeticaoModel competicao){
        this(competicao.getId(), competicao.getNome(), competicao.getModalidade(), competicao.getPresenca());
    }
}
