package akadamia.repositories;

import akadamia.models.dao.Hotel;
import akadamia.models.dto.HotelDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

  List<Hotel> findByCountry(String country);
  List<Hotel> findByCountryAndRate(String country, String rate);
  List<Hotel> findHotelByAddress_City(String city);
  @Query(value = "select id,country,rate,title from hotel where id = (select hotel_id from address where address.city = ?1)", nativeQuery = true)
  List<Hotel> findHotelByAddressCity(String city);

}
