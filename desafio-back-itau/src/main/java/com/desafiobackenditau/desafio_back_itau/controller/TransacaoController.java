package com.desafiobackenditau.desafio_back_itau.controller;

import com.desafiobackenditau.desafio_back_itau.Service.TransacaoService;
import com.desafiobackenditau.desafio_back_itau.dto.TransacaoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transacao")
@RestController
public class TransacaoController {


    public final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }


    @PostMapping
    public ResponseEntity<String> transacao(@RequestBody TransacaoDto transacaoDto){
        transacaoService.criarTransacao(transacaoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<String> deletarTudo(){
        transacaoService.deletarTransacao();
        return ResponseEntity.ok().build();
    }
}
