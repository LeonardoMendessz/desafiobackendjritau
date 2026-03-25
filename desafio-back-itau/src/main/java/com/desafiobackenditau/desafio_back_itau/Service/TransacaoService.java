package com.desafiobackenditau.desafio_back_itau.Service;

import com.desafiobackenditau.desafio_back_itau.dto.TransacaoDto;
import com.desafiobackenditau.desafio_back_itau.dto.estatiscticasDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransacaoService {


    public Queue<TransacaoDto> transacoes = new ConcurrentLinkedDeque<>();

    public void criarTransacao(TransacaoDto transacao){

        if(transacao.getDataHora() == null || transacao.getValor() <= 0){
                   throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"");
        } else if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "422");
        } else {
            transacoes.add(transacao);
        }

    }

    public void deletarTransacao(){
        transacoes.clear();
    }

    public estatiscticasDto calcularEstatisticas(){

        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);


        DoubleSummaryStatistics stats = transacoes.stream().filter(t -> t.getDataHora().isAfter(limite) ||t.getDataHora().isEqual(limite) ).mapToDouble(t -> t.getValor()).summaryStatistics();
        estatiscticasDto estatisticas = new estatiscticasDto();
        estatisticas.setCount(stats.getCount());
        estatisticas.setSum(stats.getSum());
        estatisticas.setAvg(stats.getAverage());
        estatisticas.setMin(stats.getCount() == 0 ? 0 : stats.getMin());
        estatisticas.setMax(stats.getCount() == 0 ? 0 : stats.getMax());
        return estatisticas;

    }






}
