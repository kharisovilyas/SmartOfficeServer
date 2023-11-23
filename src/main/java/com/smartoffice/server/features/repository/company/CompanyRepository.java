package com.smartoffice.server.features.repository.company;

import com.smartoffice.server.database.entity.company.CompanyData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyData, Long> {
    CompanyData findByCompanyNameIgnoreCase(String companyName);
    CompanyData findByCompanyName(String companyName);

}
