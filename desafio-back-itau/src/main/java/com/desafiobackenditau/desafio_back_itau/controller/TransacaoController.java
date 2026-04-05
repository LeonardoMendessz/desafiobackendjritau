package com.desafiobackenditau.desafio_back_itau.controller;

import com.desafiobackenditau.desafio_back_itau.Service.TransacaoService;
import com.desafiobackenditau.desafio_back_itau.dto.TransacaoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Transações", description = "Operações relacionadas a transações")
@RequestMapping("/transacao")
@RestController
public class TransacaoController {


    public final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }



    @Operation(summary = "Cria uma nova transação")
    @PostMapping
    public ResponseEntity<String> transacao(@RequestBody TransacaoDto transacaoDto){
        transacaoService.criarTransacao(transacaoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Deleta todas as transações")
    @DeleteMapping
    public ResponseEntity<String> deletarTudo(){
        transacaoService.deletarTransacao();
        return ResponseEntity.ok().build();
    }
}
