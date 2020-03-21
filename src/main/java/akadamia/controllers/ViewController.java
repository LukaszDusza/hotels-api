package akadamia.controllers;

import akadamia.services.dto.HotelServiceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  private HotelServiceDTO hotelServiceDTO;

  public ViewController(HotelServiceDTO hotelServiceDTO) {
    this.hotelServiceDTO = hotelServiceDTO;
  }

  @GetMapping("/home")
  public String getHomePage(Model model) {
    model.addAttribute("hotels", hotelServiceDTO.getHotels());
    return "index";
  }

}
