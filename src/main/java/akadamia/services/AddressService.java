package akadamia.services;

import akadamia.models.dao.Address;
import akadamia.repositories.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
  private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

  private AddressRepository addressRepository;

  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public List<Address> getAddresses() {
    return addressRepository.findAll();
  }
}
