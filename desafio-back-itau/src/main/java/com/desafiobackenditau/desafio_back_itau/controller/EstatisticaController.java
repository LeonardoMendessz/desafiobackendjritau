package com.desafiobackenditau.desafio_back_itau.controller;

import com.desafiobackenditau.desafio_back_itau.Service.TransacaoService;
import com.desafiobackenditau.desafio_back_itau.dto.estatiscticasDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estatisticas", description = "Estatisticas das transações")
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    public final TransacaoService transacaoService;

    public EstatisticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }


    @Operation(summary = "Calcula as estatisticas das transações")
    @GetMapping
    public ResponseEntity<estatiscticasDto> estatisticas (){
        estatiscticasDto transacoes = transacaoService.calcularEstatisticas();
        return ResponseEntity.ok(transacoes);
    }
}
