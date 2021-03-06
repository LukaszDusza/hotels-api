package akadamia.controllers.dto;

import akadamia.controllers.dao.HotelController;
import akadamia.models.dto.HotelDTO;
import akadamia.services.HotelService;
import akadamia.services.dto.HotelServiceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin //dodac gdy sie bawisz z frontendem
@RestController
@RequestMapping("/api/v1/dto")
public class HotelDtoRestController implements HotelService<HotelDTO> {
  private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

  private HotelServiceDTO hotelService;

  public HotelDtoRestController(HotelServiceDTO hotelService) {
    this.hotelService = hotelService;
  }

  @Override
  @GetMapping("/hotels")
  public List<HotelDTO> getHotels() {
    return hotelService.getHotels();
  }

  @Override
  @GetMapping("/hotels/country/{country}")
  public List<HotelDTO> getHotelsByCountry(@PathVariable String country) {
    return hotelService.getHotelsByCountry(country);
  }

  @Override
  @GetMapping("/hotels/city/{city}")
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
  public HotelDTO getHotelByPartnerCode(String partnerCode) {
    return null;
  }

  @Override
  @DeleteMapping("/hotels")
  public void deleteHotelByPartnerCode(@RequestParam(value = "delete") String partnerCode) {
    hotelService.deleteHotelByPartnerCode(partnerCode);

  }

  @Override
  public HotelDTO updateHotel(HotelDTO hotelDTO) {
    return null;
  }

  @Override
  @PostMapping("/hotels")
  public void addHotel(@RequestBody HotelDTO hotelDTO) {
    hotelService.addHotel(hotelDTO);
  }
}
