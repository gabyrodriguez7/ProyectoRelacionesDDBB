package uce.edu.ec.HappyPaws.Interface;

import org.springframework.data.repository.CrudRepository;
import uce.edu.ec.HappyPaws.Model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
