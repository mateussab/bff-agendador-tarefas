package com.mateus.bffagendador.business;

import com.mateus.bffagendador.business.dto.in.TarefasDTORequest;
import com.mateus.bffagendador.business.dto.out.TarefasDTOResponse;
import com.mateus.bffagendador.infrastructure.enums.StatusNotificacaoEnum;
import com.mateus.bffagendador.infrastructure.security.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravaTarefa(String token, TarefasDTORequest tarefasDTO) {
        return tarefasClient.gravaTarefas(tarefasDTO, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token){
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token){
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token){
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest tarefasDTO, String id, String token){
        return tarefasClient.updateTarefas(tarefasDTO,id,token);
    }



}
