package akadamia.mappers;

import akadamia.models.dao.Address;
import akadamia.models.dao.Hotel;
import akadamia.models.dto.AddressDTO;
import akadamia.models.dto.HotelDTO;
import akadamia.models.dto.RoomDTO;
import akadamia.utils.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper implements Mapper<Hotel, HotelDTO> {

  private AddressMapper addressMapper;
  private RoomMapper roomMapper;

  public HotelMapper(AddressMapper addressMapper, RoomMapper roomMapper) {
    this.addressMapper = addressMapper;
    this.roomMapper = roomMapper;
  }

  @Override
  public HotelDTO map(Hotel from) {

    List<RoomDTO> rooms = from.getRooms()
        .stream()
        .map(roomMapper::map)
        .collect(Collectors.toList());

    return HotelDTO
        .builder()
        .title(from.getTitle())
        .partnerCode(from.getPartnerCode())
        .country(from.getCountry())
        .rate(from.getRate())
        .address(addressMapper.map(from.getAddress()))
        .rooms(rooms)
        .build();
  }

  @Override
  public Hotel revers(HotelDTO to) {
//    Hotel hotel = new Hotel();
//    Address address = getAddressFromDTO(to.getAddress());
//    hotel.setTitle(to.getTitle());
//    hotel.setCountry(to.getCountry());
//    hotel.setRate(to.getRate());
//
//    address.
//        hotel.setAddress();
    return null;
  }

  public Address getAddressFromDTO(AddressDTO from) {
    Address address = new Address();
    address.setEmail(from.getEmail());
    address.setUrl(from.getUrl());
    address.setPhone(from.getPhone());
    String[] addr = from.getPostalAddress().trim().split(",");
    address.setCity(addr[0]);
    address.setStreet(addr[1]);
    address.setStreetNo(addr[2]);
    return address;
  }

}
