package com.desafiobackenditau.desafio_back_itau;

import com.desafiobackenditau.desafio_back_itau.Service.TransacaoService;
import com.desafiobackenditau.desafio_back_itau.dto.TransacaoDto;
import com.desafiobackenditau.desafio_back_itau.dto.estatiscticasDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ServiceTeste {


    @Test
    public void CriarTransacao_TesteCorreto(){

        // Arrange
        TransacaoService transacaoService = new TransacaoService();
        TransacaoDto transacaoDto = new TransacaoDto(20.00, OffsetDateTime.now());

        int transacoesAntes = transacaoService.transacoes.size();
        transacaoService.criarTransacao(transacaoDto);

        int transacoesDepois = transacaoService.transacoes.size();

        assertEquals(transacoesAntes + 1,transacoesDepois);

    }

    @Test
    public void CriarTransacaoFail(){
        TransacaoService transacaoService = new TransacaoService();
        OffsetDateTime hora = OffsetDateTime.now();
        TransacaoDto transacaoDto = new TransacaoDto(21.00,hora.plusSeconds(90));
        assertThrows(Exception.class,() -> transacaoService.criarTransacao(transacaoDto));
    }


    @Test
    public void CriarTransacaoNull(){
        TransacaoService transacaoService = new TransacaoService();
        TransacaoDto transacaoDto = new TransacaoDto();
        assertThrows(Exception.class,() -> transacaoService.criarTransacao(transacaoDto));
    }


    @Test
    public void DeletarTransacaoTeste(){
        TransacaoService transacaoService = new TransacaoService();

        TransacaoDto transacaoDto = new TransacaoDto(20.00,OffsetDateTime.now());
        transacaoService.criarTransacao(transacaoDto);
        int TransacaoAntes = transacaoService.transacoes.size();
        transacaoService.deletarTransacao();
        int TransacaoDepois = transacaoService.transacoes.size();

        assertEquals(0,TransacaoDepois);

    }


    @Test
    public void CalcularTransacoes_RetornaValoresCorretos(){
        TransacaoService transacaoService = new TransacaoService();

        TransacaoDto transacaoDtoOne = new TransacaoDto(20.00,OffsetDateTime.now());
        TransacaoDto transacaoDtoTwo = new TransacaoDto(10.00,OffsetDateTime.now());
        TransacaoDto transacaoDtoThree = new TransacaoDto(40.00,OffsetDateTime.now());


        transacaoService.criarTransacao(transacaoDtoOne);
        transacaoService.criarTransacao(transacaoDtoTwo);
        transacaoService.criarTransacao(transacaoDtoThree);

        estatiscticasDto estatisticas = transacaoService.calcularEstatisticas();

        assertEquals(3,estatisticas.getCount());
        assertEquals(70,estatisticas.getSum());
        assertEquals(23.33,estatisticas.getAvg(),0.01);
        assertEquals(10,estatisticas.getMin());
        assertEquals(40,estatisticas.getMax());


    }






}
