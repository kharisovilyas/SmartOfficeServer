package com.smartoffice.server.features.service.company;

import com.smartoffice.server.database.dto.company.CompanyDTO;
import com.smartoffice.server.database.entity.company.CompanyData;
import com.smartoffice.server.features.repository.company.CompanyRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<ApiResponse> updateCompanyData(CompanyDTO companyDTO) {

        CompanyData existingCompany = companyRepository.findByCompanyName(companyDTO.getCompanyName());

        if (existingCompany != null) {
            existingCompany.setDescription(companyDTO.getDescription());
            existingCompany.setFoundationDate(companyDTO.getFoundationDate());
            companyRepository.save(existingCompany);

            return ResponseEntity.ok(new ApiResponse("Data successfully updated"));

        } else {
            CompanyData newCompany = mapToCompanyEntity(companyDTO);
            companyRepository.save(newCompany);

            return ResponseEntity.ok(new ApiResponse("Data successfully added"));

        }
    }

    private CompanyData mapToCompanyEntity(CompanyDTO companyDTO) {
        CompanyData companyData = new CompanyData();
        companyData.setCompanyName(companyDTO.getCompanyName());
        companyData.setNumberOfEmployees(companyDTO.getNumberOfEmployees());
        companyData.setDescription(companyDTO.getDescription());
        companyData.setFoundationDate(companyDTO.getFoundationDate());
        // Добавьте другие поля, если необходимо
        return companyData;
    }
    private CompanyDTO mapToCompanyDTO(CompanyData company) {
        // Создаем DTO на основе сущности компании
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyId(company.getCompanyId());
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setNumberOfEmployees(company.getNumberOfEmployees());
        companyDTO.setDescription(company.getDescription());
        companyDTO.setFoundationDate(company.getFoundationDate());
        // Добавьте другие поля, если необходимо
        return companyDTO;
    }

    public List<CompanyDTO> getAllCompanies() {
        List<CompanyData> companies = StreamSupport.stream(companyRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return companies.stream()
                .map(this::mapToCompanyDTO)
                .toList();
    }
}
