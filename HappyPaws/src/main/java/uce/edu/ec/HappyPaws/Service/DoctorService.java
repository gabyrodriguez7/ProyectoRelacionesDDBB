package uce.edu.ec.HappyPaws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.HappyPaws.Interface.DoctorRepository;
import uce.edu.ec.HappyPaws.Model.Doctor;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(long id) {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(long id) {
        doctorRepository.deleteById(id);
    }
}