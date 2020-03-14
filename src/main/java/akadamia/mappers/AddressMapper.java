package akadamia.mappers;

import akadamia.models.dao.Address;
import akadamia.models.dto.AddressDTO;
import akadamia.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressDTO> {

  @Override
  public AddressDTO map(Address from) {
    return AddressDTO
        .builder()
        .email(from.getEmail())
        .phone(from.getPhone())
        .url(from.getUrl())
        .postalAddress(from.getCity() + ", " + from.getStreet() + ", " + from.getStreetNo())
        .build();
  }

  @Override
  public Address revers(AddressDTO to) {
    return null;
  }
}
