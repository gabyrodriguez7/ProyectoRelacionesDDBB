package uce.edu.ec.HappyPaws.Model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_address;

    private String street;
    private String city;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Customer customer;

    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public long getId_address() {
        return id_address;
    }

    public void setId_address(long id_address) {
        this.id_address = id_address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
