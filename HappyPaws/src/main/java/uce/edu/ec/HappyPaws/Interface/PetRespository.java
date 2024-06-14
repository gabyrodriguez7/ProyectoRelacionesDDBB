package uce.edu.ec.HappyPaws.Interface;

import org.springframework.data.repository.CrudRepository;
import uce.edu.ec.HappyPaws.Model.Pet;

public interface PetRespository extends CrudRepository<Pet,Long> {
}
