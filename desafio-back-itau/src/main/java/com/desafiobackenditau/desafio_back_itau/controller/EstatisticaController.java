package com.desafiobackenditau.desafio_back_itau.controller;

import com.desafiobackenditau.desafio_back_itau.Service.TransacaoService;
import com.desafiobackenditau.desafio_back_itau.dto.estatiscticasDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    public final TransacaoService transacaoService;

    public EstatisticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }


    @GetMapping
    public ResponseEntity<estatiscticasDto> estatisticas (){
        estatiscticasDto transacoes = transacaoService.calcularEstatisticas();
        return ResponseEntity.ok(transacoes);
    }
}
