package com.smartoffice.server.features.repository;

import com.smartoffice.server.database.entity.company.CompanyData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyData, Long> {
    Optional<CompanyData> findByCompanyName(String companyName);
}

