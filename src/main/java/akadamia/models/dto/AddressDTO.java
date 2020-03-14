package akadamia.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

  private String postalAddress;
  private String email;
  private String phone;
  private String url;
  //todo dodać dane geograficzne z google maps.
}
