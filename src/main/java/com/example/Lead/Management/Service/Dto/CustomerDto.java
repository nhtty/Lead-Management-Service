package com.example.Lead.Management.Service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

    public class CustomerDto {
        private Long customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String street;
        private String city;
        private String state;
        private String zipcode;
        private String notes;
        private CustomFieldsDto customFields;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class CustomFieldsDto {
            private String birthday;
            private String company;
        }
    
}
