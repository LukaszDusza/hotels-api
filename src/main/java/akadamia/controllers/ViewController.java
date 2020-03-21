package akadamia.controllers;

import akadamia.models.dto.AddressDTO;
import akadamia.models.dto.HotelDTO;
import akadamia.services.dto.HotelServiceDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

  private HotelServiceDTO hotelServiceDTO;

  public ViewController(HotelServiceDTO hotelServiceDTO) {
    this.hotelServiceDTO = hotelServiceDTO;
  }

  @GetMapping("/home")
  public String getHomePage(
      Model model, @RequestParam(value = "info", required = false) String info,
      @RequestParam(value = "message", required = false) String message) {
    model.addAttribute("info", info);
    model.addAttribute("hotels", hotelServiceDTO.getHotels());
    model.addAttribute("message", message);
    SecurityContext context = SecurityContextHolder.getContext();
    String login = context.getAuthentication().getName();
    model.addAttribute("login", "You are logged in as: " + login);
    return "index";
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
  @GetMapping("/edit-page")
  public String getEditPage(@RequestParam(value = "uuid") String uuid, Model model) {
    HotelDTO hotelDTO = hotelServiceDTO.getHotelByPartnerCode(uuid);
    model.addAttribute("hotel", hotelDTO);
    return "edit-hotel";
  }

  @PostMapping("/edit-save")
  public String getEdit(@ModelAttribute HotelDTO hotelDTO, @RequestParam(name = "email") String email) {
    HotelDTO before = hotelServiceDTO.getHotelByPartnerCode(hotelDTO.getPartnerCode());
    before.setTitle(hotelDTO.getTitle());
    before.setCountry(hotelDTO.getCountry());
    before.setRate(hotelDTO.getRate());
    before.getAddress().setEmail(email);
    hotelServiceDTO.updateHotel(before);
    String info = before.getTitle();
    return "redirect:/home?info=" + info;
  }
}
