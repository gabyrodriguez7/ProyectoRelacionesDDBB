package uce.edu.ec.HappyPaws.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.HappyPaws.Model.Address;
import uce.edu.ec.HappyPaws.Service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") long id) {
        return addressService.getAddressById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
        address.setId_address(id); // Asegura que el ID de la dirección sea el mismo que el proporcionado en la URL
        return addressService.saveAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") long id) {
        addressService.deleteAddress(id);
    }
}