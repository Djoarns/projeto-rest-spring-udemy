package br.com.arns.api.repositories;

import br.com.arns.api.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCnpj(String cnpj);
}
