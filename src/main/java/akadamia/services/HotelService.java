package akadamia.services;

import akadamia.exceptions.ResourceNotFoundException;
import akadamia.mappers.HotelMapper;
import akadamia.models.dao.Hotel;
import akadamia.models.dto.HotelDTO;
import akadamia.repositories.AddressRepository;
import akadamia.repositories.HotelRepository;
import akadamia.repositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
  private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

  private HotelRepository hotelRepository;
  private AddressRepository addressRepository;
  private HotelMapper hotelMapper;
  private RoomRepository roomRepository;

  public HotelService(HotelRepository hotelRepository, AddressRepository addressRepository, HotelMapper hotelMapper, RoomRepository roomRepository) {
    this.hotelRepository = hotelRepository;
    this.addressRepository = addressRepository;
    this.hotelMapper = hotelMapper;
    this.roomRepository = roomRepository;
  }

  public List<Hotel> getHotels() {
    List<Hotel> hotels = hotelRepository.findAll();
    logger.debug("Hotels: {}", hotels);
    MDC.clear();
    return hotels;
  }

  public Hotel getHotelById(Long id) {
    return hotelRepository.findById(id) //zwraca Optional
        .orElseThrow(() -> new ResourceNotFoundException("Not found Hotel by id: " + id));
  }

  public List<Hotel> getHotelsByCountry(String country) {
    return hotelRepository.findByCountry(country);
  }

  public List<Hotel> getHotelsByCountryAndRate(String country, String rate) {
    return hotelRepository.findByCountryAndRate(country, rate);
  }

  /**
   * ======================= DTO ================================
   */

  public List<HotelDTO> getHotelsDto() {
    List<Hotel> hotels = hotelRepository.findAll();
    return hotels.stream()
        .map(hotelMapper::map)
        .collect(Collectors.toList());
  }

}
