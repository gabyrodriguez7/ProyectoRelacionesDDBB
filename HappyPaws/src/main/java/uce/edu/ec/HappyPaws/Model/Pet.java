package uce.edu.ec.HappyPaws.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pet;

    private String name;
    private String type;
    private int age;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "pet_doctor",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;
    public long getId_pet() {
        return id_pet;
    }

    public void setId_pet(long id_pet) {
        this.id_pet = id_pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
