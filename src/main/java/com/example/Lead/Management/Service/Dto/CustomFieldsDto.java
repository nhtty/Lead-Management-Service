package com.example.Lead.Management.Service.Dto;

import com.example.Lead.Management.Service.Model.CustomFields;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomFieldsDto {
    private String industry;
    private Integer leadScore;
    private String birthday;
    private String company;

    public CustomFieldsDto(CustomFields customFields) {
        this.industry = customFields.getIndustry();
        this.leadScore = customFields.getLeadScore();

    }
}
