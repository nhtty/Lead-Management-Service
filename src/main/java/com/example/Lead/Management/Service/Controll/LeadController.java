package com.example.Lead.Management.Service.Controll;

import com.example.Lead.Management.Service.Model.Leads;
import com.example.Lead.Management.Service.Service.LeadServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    private LeadServiceimp leadServiceimp;

    @PostMapping("/create")
    public ResponseEntity<?> createLead(@RequestBody Leads leadTable) {
        return new ResponseEntity<>(leadServiceimp.createLead(leadTable), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Leads> getAllLeads() {
        return leadServiceimp.getAllLeads();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Leads> updateLead(@PathVariable int id, @RequestBody Leads leadTableDetails) {
        Leads updatedLeadTable = leadServiceimp.updateLead( id, leadTableDetails);
        return ResponseEntity.ok(updatedLeadTable);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable int id) {
        leadServiceimp.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}