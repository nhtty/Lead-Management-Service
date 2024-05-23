package com.example.Lead.Management.Service.Dto;


import com.example.Lead.Management.Service.Model.Leads;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeadDto {
    private Long leadId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private String status;
    private String source;
    private CustomFieldsDto customFields;

    private String message;
    public LeadDto(Leads lead, String message) {
        this.leadId = lead.getId();
        this.firstName = lead.getFirstName();
        this.lastName = lead.getLastName();
        this.email = lead.getEmail();
        this.phone = lead.getPhone();
        this.company = lead.getCompany();
        this.status = lead.getStatus();
        this.source = lead.getSource();
        this.customFields = new CustomFieldsDto(lead.getCustomFields());
        this.message = message;
    }
}
