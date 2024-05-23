package com.example.Lead.Management.Service.Service;

import com.example.Lead.Management.Service.Dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class CustomerManagementService {

    @Autowired
 RestTemplate restTemplate;

    private static final String url = "http://localhost:8081/customers";

    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        return restTemplate.postForEntity(url + "/create", customerDto, CustomerDto.class);
    }

    public void updateCustomer(Long customerId, CustomerDto customerDto) {
        restTemplate.put(url + "/update/" + customerId, customerDto);
    }
}
