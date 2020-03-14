package akadamia.controllers;

import akadamia.models.dao.Address;
import akadamia.services.dao.AddressServiceDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AddressController {

  private AddressServiceDAO addressServiceDAO;

  public AddressController(AddressServiceDAO addressServiceDAO) {
    this.addressServiceDAO = addressServiceDAO;
  }

  @GetMapping("/addresses")
  public List<Address> getAddresses() {
    return addressServiceDAO.getAddresses();
  }
}
