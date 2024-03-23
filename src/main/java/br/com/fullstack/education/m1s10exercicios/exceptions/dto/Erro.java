package br.com.fullstack.education.m1s10exercicios.exceptions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Erro {

    private String codigo;
    private String mensagem;

}
