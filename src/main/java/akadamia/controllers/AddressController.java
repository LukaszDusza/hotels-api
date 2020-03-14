package akadamia.controllers;

import akadamia.models.dao.Address;
import akadamia.services.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AddressController {

  private AddressService addressService;

  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping("/addresses")
  public List<Address> getAddresses() {
    return addressService.getAddresses();
  }
}
