package akadamia.services.dao;

import akadamia.models.dao.Address;
import akadamia.repositories.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceDAO {
  private static final Logger logger = LoggerFactory.getLogger(AddressServiceDAO.class);

  private AddressRepository addressRepository;

  public AddressServiceDAO(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public List<Address> getAddresses() {
    return addressRepository.findAll();
  }
}
