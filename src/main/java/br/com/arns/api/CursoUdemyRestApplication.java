package br.com.arns.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CursoUdemyRestApplication {

    @Value("${paginacao.qtd_por_pagina}")
    private int qtdPorPagina;

    public static void main(String[] args) {
        SpringApplication.run(CursoUdemyRestApplication.class, args);
        System.out.println("Testando primeiro commit");
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("### Quantidade de elementos por página = " + qtdPorPagina);
    }

}
