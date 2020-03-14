package akadamia.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
  private String title;
  private String country;
  private String rate;
  private AddressDTO address;
  private List<RoomDTO> rooms;
}
