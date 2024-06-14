package uce.edu.ec.HappyPaws.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.HappyPaws.Model.Pet;
import uce.edu.ec.HappyPaws.Service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable("id") long id) {
        return petService.getPetById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable("id") long id, @RequestBody Pet pet) {
        pet.setId_pet(id); // Asegura que el ID de la mascota sea el mismo que el proporcionado en la URL
        return petService.savePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") long id) {
        petService.deletePet(id);
    }
}
