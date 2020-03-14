package akadamia.controllers.dto;

import akadamia.controllers.dao.HotelController;
import akadamia.models.dto.HotelDTO;
import akadamia.services.HotelService;
import akadamia.services.dto.HotelServiceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/dto")
public class HotelDtoController implements HotelService<HotelDTO> {
  private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

  private HotelServiceDTO hotelService;

  public HotelDtoController(HotelServiceDTO hotelService) {
    this.hotelService = hotelService;
  }

  @Override
  @GetMapping("/hotels")
  public List<HotelDTO> getHotels() {
    return hotelService.getHotels();
  }

  @Override
  @GetMapping("/hotels/{country}")
  public List<HotelDTO> getHotelsByCountry(@PathVariable String country) {
    return hotelService.getHotelsByCountry(country);
  }

  @Override
  @GetMapping("/hotels/{city}")
  public List<HotelDTO> getHotelsByCity(@PathVariable String city) {
    return hotelService.getHotelsByCity(city);
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
}
