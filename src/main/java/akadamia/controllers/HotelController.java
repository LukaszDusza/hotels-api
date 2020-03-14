package akadamia.controllers;

import akadamia.models.dao.Hotel;
import akadamia.models.dto.HotelDTO;
import akadamia.services.dao.HotelServiceDAO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class HotelController {
  private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

  private HotelServiceDAO hotelServiceDAO;

  public HotelController(HotelServiceDAO hotelServiceDAO) {
    this.hotelServiceDAO = hotelServiceDAO;
  }


  @GetMapping("/hotels/{id}/id")
  public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
    return ResponseEntity.ok(hotelServiceDAO.getHotelById(id));
  }

  @GetMapping("/hotels/{country}/country")
  public ResponseEntity<List<Hotel>> getHotelByCountry(@PathVariable String country) {
    return ResponseEntity.ok(hotelServiceDAO.getHotelsByCountry(country));
  }

  @GetMapping("/hotels")
  public ResponseEntity<List<Hotel>> getHotelByCountryAndRate(
      @RequestParam(required = false) String country,
      @RequestParam(required = false) String rate) {
    if (StringUtils.isNotBlank(country) && StringUtils.isNotBlank(rate)) {
      return ResponseEntity.ok(hotelServiceDAO.getHotelsByCountryAndRate(country, rate));
    }
    return ResponseEntity.ok(hotelServiceDAO.getHotels());
  }

}
