package com.example.GetRide.service;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Transformer.CustomerTransformer;
import com.example.GetRide.dtos.request.CustomerRequest;
import com.example.GetRide.dtos.request.response.CustomerResponse;
import com.example.GetRide.models.Customer;
import com.example.GetRide.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerResponse getCoustomer(String email) {
        Customer savedCustomer = customerRepo.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

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
        for (Customer customer : saveCustomer) {
            customerRespons.add(CustomerTransformer.coustomerToCoustomerResponse(customer));
        }
        return customerRespons;
    }

    public CustomerResponse updateCustomer(String email, CustomerRequest customerRequest) {
        Customer customer = customerRepo.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setGender(customerRequest.getGender());

        Customer updatedCustomer = customerRepo.save(customer);
        return CustomerTransformer.coustomerToCoustomerResponse(updatedCustomer);
    }

    public void deleteCustomer(String email) {
        Customer customer = customerRepo.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerRepo.delete(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
         List<Customer> customers = customerRepo.getAllCustomers();
         List<CustomerResponse> customerResponseList = new ArrayList<>();
         for(Customer customer : customers){
             CustomerResponse customerResponse = CustomerTransformer.coustomerToCoustomerResponse(customer);
              customerResponseList.add(customerResponse);
          }

         return customerResponseList;

    }

    public List<CustomerResponse> getCustomersByAgeRange(int minAge, int maxAge) {
        return customerRepo.findByAgeBetween(minAge, maxAge).stream()
                .map(CustomerTransformer::coustomerToCoustomerResponse)
                .collect(Collectors.toList());
    }

    public List<CustomerResponse> searchCustomersByName(String name) {
        return customerRepo.findByNameContainingIgnoreCase(name).stream()
                .map(CustomerTransformer::coustomerToCoustomerResponse)
                .collect(Collectors.toList());
    }

    public long countCustomersByGender(Gender gender) {
        return customerRepo.countByGender(gender);
    }

    public void deactivateCustomer(String email) {
        Customer customer = customerRepo.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setActive(false);
        customerRepo.save(customer);
    }

    public void reactivateCustomer(String email) {
        Customer customer = customerRepo.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setActive(true);
        customerRepo.save(customer);
    }

    public void deleteALLCoustomer() {
        customerRepo.deleteAll();
    }
}
