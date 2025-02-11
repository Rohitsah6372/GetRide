package com.example.GetRide.Transformer;

import com.example.GetRide.dtos.request.CustomerRequest;
import com.example.GetRide.dtos.request.response.CustomerResponse;
import com.example.GetRide.models.Customer;

public class CustomerTransformer {

    public static Customer coustomerRequestToCoustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .Active(customerRequest.isActive())
                .createdAt(customerRequest.getCreatedAt())
                .build();
    }

    public static CustomerResponse coustomerToCoustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .emailId(customer.getEmailId())
                .name(customer.getName())
                .gender(customer.getGender())
                .Active(customer.getActive())
                .createdAt(customer.getCreatedAt())
                .build();
    }


}
