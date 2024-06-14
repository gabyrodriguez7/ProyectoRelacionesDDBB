package uce.edu.ec.HappyPaws.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_doctor;

    private String name_doctor;
    private String description;

    @ManyToMany(mappedBy = "doctors")
    private List<Pet> pets;


    public long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getName_doctor() {
        return name_doctor;
    }

    public void setName_doctor(String name_doctor) {
        this.name_doctor = name_doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
