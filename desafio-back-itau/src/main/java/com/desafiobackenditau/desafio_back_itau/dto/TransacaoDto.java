package com.desafiobackenditau.desafio_back_itau.dto;


import java.time.OffsetDateTime;


public class TransacaoDto {

    private double valor;

    private OffsetDateTime dataHora;

    public void setValor(double valor){
        this.valor = valor;
    }

    public void setDataHora(OffsetDateTime dataHora){
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora(){
        return dataHora;
    }


    public TransacaoDto(){};

    public TransacaoDto(double valor, OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }


}
