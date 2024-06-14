package uce.edu.ec.HappyPaws;
/**
 * @author: Gabriela Lissette Rodriguez Contreras
 *
 *
 *
 * Tema: Relacion entre tablas: OnetoOne, ManytoOne, OnetoMany, ManytoMany
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uce.edu.ec.HappyPaws.Interface.AddressRespository;
import uce.edu.ec.HappyPaws.Interface.CustomerRepository;
import uce.edu.ec.HappyPaws.Interface.DoctorRepository;
import uce.edu.ec.HappyPaws.Model.Address;
import uce.edu.ec.HappyPaws.Model.Customer;
import uce.edu.ec.HappyPaws.Model.Doctor;
import uce.edu.ec.HappyPaws.Model.Pet;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HappyPawsApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRespository addressRespository;
	@Autowired
    DoctorRepository doctorRepository;

	public static void main(String[] args) {
		SpringApplication.run(HappyPawsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Floresta", "Quito");
		Customer customer = new Customer("Luisa", address);

		Pet pet = new Pet();
		pet.setName("Firulais");
		pet.setType("Dog");
		pet.setAge(5);
		pet.setCustomer(customer);

		List<Doctor> doctors = new ArrayList<>();

		Doctor doctor1 = new Doctor();
		doctor1.setName_doctor("Dr. Watson");
		doctor1.setDescription("Veterinarian specialized in dogs");
		doctorRepository.save(doctor1); // Guardar primero el doctor

		Doctor doctor2 = new Doctor();
		doctor2.setName_doctor("Dr. Smith");
		doctor2.setDescription("Veterinarian for all pets");
		doctorRepository.save(doctor2); // Guardar primero el doctor

		doctors.add(doctor1);
		doctors.add(doctor2);

		pet.setDoctors(doctors);

		List<Pet> pets = new ArrayList<>();
		pets.add(pet);

		customer.setPets(pets);

		address.setCustomer(customer); // Establecer la relación inversa si es necesario

		addressRespository.save(address); // Guardar primero la dirección si es la dueña de la relación
		customerRepository.save(customer);
	}
}
