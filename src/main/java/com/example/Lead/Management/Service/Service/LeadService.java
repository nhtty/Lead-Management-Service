package com.example.Lead.Management.Service.Service;

import com.example.Lead.Management.Service.Dto.LeadDto;
import com.example.Lead.Management.Service.Model.Leads;

import java.util.List;

public interface LeadService {
    public LeadDto createLead (Leads leadTable);

    List<Leads> getAllLeads();

    Leads updateLead(int id, Leads leadTableDetails);

    public void deleteLead(int id);
}