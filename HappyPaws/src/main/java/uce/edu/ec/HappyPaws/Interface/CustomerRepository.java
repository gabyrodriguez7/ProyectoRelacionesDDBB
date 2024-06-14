package uce.edu.ec.HappyPaws.Interface;

import org.springframework.data.repository.CrudRepository;
import uce.edu.ec.HappyPaws.Model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
