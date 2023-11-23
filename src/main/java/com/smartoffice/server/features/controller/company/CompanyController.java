package com.smartoffice.server.features.controller.company;

import com.smartoffice.server.database.dto.company.CompanyDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies/")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.updateCompanyData(companyDTO);
    }
}
