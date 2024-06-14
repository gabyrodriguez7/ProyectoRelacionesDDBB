package uce.edu.ec.HappyPaws.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.HappyPaws.Model.Doctor;
import uce.edu.ec.HappyPaws.Service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable("id") long id) {
        return doctorService.getDoctorById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor) {
        doctor.setId_doctor(id); // Asegura que el ID del doctor sea el mismo que el proporcionado en la URL
        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable("id") long id) {
        doctorService.deleteDoctor(id);
    }
}
