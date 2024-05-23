package com.example.Lead.Management.Service.Dto;

import com.example.Lead.Management.Service.Model.Leads;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Response {
        private Leads leadTable;
        private String message;

        public Response(Leads lead, String message) {
            this.leadTable = lead;
            this.message = message;
        }


    }
