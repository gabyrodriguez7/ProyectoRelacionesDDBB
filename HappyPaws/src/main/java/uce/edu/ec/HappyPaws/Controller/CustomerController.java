package uce.edu.ec.HappyPaws.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.HappyPaws.Model.Customer;
import uce.edu.ec.HappyPaws.Service.CustomerService;

import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") long id) {
        return customerService.getCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        // Asegura que la relación bidireccional con Address se establezca correctamente
        if (customer.getAddress() != null) {
            customer.getAddress().setCustomer(customer);
        }
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        customer.setId_customer(id); // Asegura que el ID del cliente sea el mismo que el proporcionado en la URL
        // Asegura que la relación bidireccional con Address se establezca correctamente
        if (customer.getAddress() != null) {
            customer.getAddress().setCustomer(customer);
        }
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
    }
}
