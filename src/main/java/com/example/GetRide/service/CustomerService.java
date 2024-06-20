package com.example.GetRide.service;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Transformer.CustomerTransformer;
import com.example.GetRide.dtos.request.CustomerRequest;
import com.example.GetRide.dtos.request.response.CustomerResponse;
import com.example.GetRide.models.Customer;
import com.example.GetRide.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final  CustomerRepo customerRepo;

    public CustomerResponse getCoustomer(String email) {
         Customer savedCustomer = customerRepo.findByEmailId(email);
        return CustomerTransformer.coustomerToCoustomerResponse(savedCustomer);
    }

    public CustomerResponse addCoustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.coustomerRequestToCoustomer(customerRequest);
        Customer savedCustomer = customerRepo.save(customer);
        return CustomerTransformer.coustomerToCoustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getAllByGenderandAgeGreaterThen(Gender gender, int age) {
        List<Customer> saveCustomer = customerRepo.getAllByGenderandAgeGreaterThen(gender, age);
        List<CustomerResponse> customerRespons = new ArrayList<>();
        for(Customer customer : saveCustomer){
            customerRespons.add(CustomerTransformer.coustomerToCoustomerResponse(customer));
        }
        return customerRespons;
    }



}
