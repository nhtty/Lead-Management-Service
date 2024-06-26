package com.example.Lead.Management.Service.Service;

import com.example.Lead.Management.Service.Dto.CustomerDto;
import com.example.Lead.Management.Service.Dto.LeadDto;
import com.example.Lead.Management.Service.Model.Leads;
import com.example.Lead.Management.Service.Repo.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceimp implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    CustomerManagementService customerManagementService;

    @Override
    public LeadDto createLead(Leads leadTable) {
        leadTable.setStatus("Open");
        CustomerDto customerDto = convertToCustomerDto(leadTable);
        customerManagementService.createCustomer(customerDto);


        Leads newLead = leadRepository.save(leadTable);
        return new LeadDto(newLead,"Leads Created Successfully");
    }
    @Override
    public List<Leads> getAllLeads() {
        return leadRepository.findAll();
    }
    @Override
    public Leads updateLead(int id, Leads leadTableDetails) {
        Leads leadTable = leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Leads not found"));

        leadTable.setFirstName(leadTableDetails.getFirstName());
        leadTable.setLastName(leadTableDetails.getLastName());
        leadTable.setEmail(leadTableDetails.getEmail());
        leadTable.setPhone(leadTableDetails.getPhone());
        leadTable.setCompany(leadTableDetails.getCompany());
        leadTable.setSource(leadTableDetails.getSource());
        leadTable.setCustomFields(leadTableDetails.getCustomFields());

        return leadRepository.save(leadTable);
    }
    @Override
    public void deleteLead(int id) {
        Leads leadTable = leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Leads not found"));
        leadRepository.delete(leadTable);
    }

    private CustomerDto convertToCustomerDto(Leads lead) {
        CustomerDto.CustomFieldsDto customFieldsDto = new CustomerDto.CustomFieldsDto();
        customFieldsDto.setCompany(lead.getCompany());
        // Assuming birthday is not available in lead, but if it is, map it

        return new CustomerDto(
                null, // Assuming customerId will be generated by CMS
                lead.getFirstName(),
                lead.getLastName(),
                lead.getEmail(),
                lead.getPhone(),
                null, // Assuming address fields are not available in lead
                null,
                null,
                null,
                "Converted from lead", // Notes
                customFieldsDto
        );
    }
}
