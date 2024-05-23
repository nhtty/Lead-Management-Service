package com.example.Lead.Management.Service.Repo;

import com.example.Lead.Management.Service.Model.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Leads,Integer> {
    Optional<Leads> findById(int id);
}
