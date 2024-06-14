package uce.edu.ec.HappyPaws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.HappyPaws.Interface.PetRespository;
import uce.edu.ec.HappyPaws.Model.Pet;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private final PetRespository petRepository;

    @Autowired
    public PetService(PetRespository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }

    public Optional<Pet> getPetById(long id) {
        return petRepository.findById(id);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(long id) {
        petRepository.deleteById(id);
    }
}
