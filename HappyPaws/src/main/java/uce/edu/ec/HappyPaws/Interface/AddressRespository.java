package uce.edu.ec.HappyPaws.Interface;

import org.springframework.data.repository.CrudRepository;
import uce.edu.ec.HappyPaws.Model.Address;

public interface AddressRespository extends CrudRepository<Address,Long> {
}
