package akadamia.services;

import akadamia.models.dto.HotelDTO;

import java.util.List;

public interface HotelService<T> {

  List<T> getHotels();

  List<T> getHotelsByCountry(String country);

  List<T> getHotelsByCity(String city);

  List<T> getHotelsByRate(String rate);

  List<T> getHotelsByRoomType(String type);

  HotelDTO getHotelByPartnerCode(String partnerCode);

  void deleteHotelByPartnerCode(String partnerCode);

  HotelDTO updateHotel(HotelDTO hotelDTO);

  void addHotel(HotelDTO hotelDTO);

}
