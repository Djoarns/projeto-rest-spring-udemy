package br.com.arns.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CursoUdemyRestApplicationTests {

    @Value("${paginacao.qtd_por_pagina}")
    private int qtdPorPagina;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCarregarContextoDeTeste() {
        Assertions.assertEquals(100, qtdPorPagina);
    }
}
