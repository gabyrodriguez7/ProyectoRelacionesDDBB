package uce.edu.ec.HappyPaws.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.HappyPaws.Interface.AddressRespository;
import uce.edu.ec.HappyPaws.Model.Address;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRespository addressRepository;

    @Autowired
    public AddressService(AddressRespository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    public Optional<Address> getAddressById(long id) {
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }
}