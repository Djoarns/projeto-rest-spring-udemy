package br.com.arns.api;

import br.com.arns.api.entities.Company;
import br.com.arns.api.repositories.CompanyRepository;
import br.com.arns.api.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CursoUdemyRestApplication {

    @Value("${paginacao.qtd_por_pagina}")
    private int qtdPorPagina;

    @Autowired
    private CompanyRepository companyRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoUdemyRestApplication.class, args);
        System.out.println("Testando primeiro commit");
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            //Testes principais funções do JPA

            Company company = new Company();
            company.setCompanyName("Dj inc.");
            company.setCnpj("1234567890");

            this.companyRepository.save(company);

            List<Company> companies = companyRepository.findAll();
            companies.forEach(System.out::println);

            Company companyDB = companyRepository.findById(1L).get();
            System.out.println("Empresa por cnpj: " + companyDB);

            companyDB.setCompanyName("Dj's alter");
            this.companyRepository.save(companyDB);

            Company companyCNPJ = companyRepository.findByCnpj("1234567890");
            System.out.println("Empresa por CNPJ2: " + companyCNPJ);

            this.companyRepository.delete(companyCNPJ);
            companies = companyRepository.findAll();
            System.out.println(companies);


            // Testes criptografia de senhas
            String encodedPassword = PasswordUtils.encryptPassword("123456");
            System.out.println(encodedPassword);

            encodedPassword = PasswordUtils.encryptPassword("123456");
            System.out.println(encodedPassword);

            System.out.println("Senha válida: " + PasswordUtils.validatePassword("123456", encodedPassword));

            // Teste busca de valores das properties da aplicação
            System.out.println("### Quantidade de elementos por página = " + qtdPorPagina);
        };
    }

}
