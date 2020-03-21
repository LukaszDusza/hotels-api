package akadamia.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
  private String title;
  private String partnerCode;
  private String country;
  private String rate;
  private AddressDTO address;
  private List<RoomDTO> rooms;

  @Override
  public String toString() {
    return new ToStringBuilder(this.getClass().getName())
        .append("title", title)
        .append("partnerCode", partnerCode)
        .append("country", country)
        .append("rate", rate)
        .append("address", address)
        .append("rooms", rooms)
        .toString();
  }
}
