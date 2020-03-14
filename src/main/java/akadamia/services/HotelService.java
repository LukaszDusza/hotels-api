package akadamia.services;

import java.util.List;
import java.util.Optional;

public interface HotelService<T> {

  List<T> getHotels();
  List<T> getHotelsByCountry(String country);
  List<T> getHotelsByCity(String city);
  List<T> getHotelsByRate(String rate);
  List<T> getHotelsByRoomType(String type);

  Optional<T> getHotelByPartnerCode(String partnerCode);

  void deleteHotelByPartnerCode(String partnerCode);

}
