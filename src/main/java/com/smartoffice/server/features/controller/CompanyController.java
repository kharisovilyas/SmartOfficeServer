package com.smartoffice.server.features.controller;

import com.smartoffice.server.database.dto.company.CompanyDTO;
import com.smartoffice.server.database.entity.company.CompanyData;
import com.smartoffice.server.features.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/companies/")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        // Получаем список всех компаний
        List<CompanyData> companies = StreamSupport.stream(companyRepository.findAll().spliterator(), true).toList();

        // Преобразуем список компаний в список DTO
        List<CompanyDTO> companyDTOs = companies.stream()
                .map(this::mapToCompanyDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(companyDTOs);
    }

    @PostMapping("/update")
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) {
        Optional<CompanyData> existingCompanyOptional = companyRepository.findByCompanyName(companyDTO.getCompanyName());
        if (existingCompanyOptional.isPresent()) {
            CompanyData existingCompany = existingCompanyOptional.get();
            // Если компания существует, обновляем её данные
            existingCompany.setCompanyName(companyDTO.getCompanyName());
            existingCompany.setDescription(companyDTO.getDescription());
            existingCompany.setNumberOfEmployees(companyDTO.getNumberOfEmployees());
            existingCompany.setFoundationDate(companyDTO.getFoundationDate());

            CompanyData updatedCompany = companyRepository.save(existingCompany);
            CompanyDTO updatedCompanyDTO = mapToCompanyDTO(updatedCompany);

            return ResponseEntity.ok(updatedCompanyDTO);
        } else {
            // Если компания не существует, создаем новую запись
            CompanyData newCompany = mapToCompanyEntity(companyDTO);
            CompanyData savedCompany = companyRepository.save(newCompany);
            CompanyDTO savedCompanyDTO = mapToCompanyDTO(savedCompany);

            return ResponseEntity.ok(savedCompanyDTO);
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
        companyDTO.setDescription(companyDTO.getDescription());
        companyDTO.setFoundationDate(companyDTO.getFoundationDate());
        // Добавьте другие поля, если необходимо
        return companyDTO;
    }
}
