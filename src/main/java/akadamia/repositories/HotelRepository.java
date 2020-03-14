package akadamia.repositories;

import akadamia.models.dao.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

  @Query("select h from Hotel h")//JPQL
  List<Hotel> findAllHotels();

  List<Hotel> findByCountry(String country);

  List<Hotel> findByCountryAndRate(String country, String rate);

  @Query(value = "select h from Hotel h where h = (select a.hotel from Address a where a.city = ?1)") //JPQL
  List<Hotel> findHotelByAddressCity(String city);

//@Query("delete from Hotel h where h.partnerCode = :partnerCode") //JPQL
  @Transactional
  @Modifying
  void deleteHotelByPartnerCode(String partnerCode);

}
