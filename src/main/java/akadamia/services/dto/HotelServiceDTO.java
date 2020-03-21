package akadamia.services.dto;

import akadamia.mappers.HotelMapper;
import akadamia.models.dao.Address;
import akadamia.models.dao.Hotel;
import akadamia.models.dto.HotelDTO;
import akadamia.repositories.AddressRepository;
import akadamia.repositories.HotelRepository;
import akadamia.repositories.RoomRepository;
import akadamia.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceDTO implements HotelService<HotelDTO> {

  private static final Logger logger = LoggerFactory.getLogger(HotelServiceDTO.class);
  private HotelRepository hotelRepository;
  private AddressRepository addressRepository;
  private HotelMapper hotelMapper;
  private RoomRepository roomRepository;

  public HotelServiceDTO(HotelRepository hotelRepository, AddressRepository addressRepository, HotelMapper hotelMapper, RoomRepository roomRepository) {
    this.hotelRepository = hotelRepository;
    this.addressRepository = addressRepository;
    this.hotelMapper = hotelMapper;
    this.roomRepository = roomRepository;
  }

  @Override
  public List<HotelDTO> getHotels() {
    return hotelRepository.findAllHotels()
        .stream()
        .map(hotelMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public List<HotelDTO> getHotelsByCountry(String country) {
    return hotelRepository.findByCountry(country)
        .stream()
        .map(hotelMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public List<HotelDTO> getHotelsByCity(String city) {
    return hotelRepository.findHotelByAddressCity(city)
        .stream()
        .map(hotelMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public List<HotelDTO> getHotelsByRate(String rate) {
    return null;
  }

  @Override
  public List<HotelDTO> getHotelsByRoomType(String type) {
    return null;
  }

  @Override
  public Optional<HotelDTO> getHotelByPartnerCode(String partnerCode) {
    return Optional.empty();
  }

  @Override
  public void deleteHotelByPartnerCode(String partnerCode) {
    hotelRepository.deleteHotelByPartnerCode(partnerCode);
  }

  //todo zamienic na cos zgrabnieszego :)
  @Override
  public void addHotel(HotelDTO hotelDTO) {
    Hotel hotel = new Hotel();
    hotel.setTitle(hotelDTO.getTitle());
    hotel.setCountry(hotelDTO.getCountry());
    hotel.setRate(hotelDTO.getRate());
    hotel.setPartnerCode(UUID.randomUUID().toString());
    hotel.setRooms(roomRepository.findAll()); //todo trzeba zrobic konwersje dto na dao
    Hotel result = hotelRepository.save(hotel); //to zwraca mi hotel z juz nadamy id
    Address address = hotelMapper.getAddressFromDTO(hotelDTO.getAddress());
    address.setHotel(result);
    addressRepository.save(address);
  }
}
