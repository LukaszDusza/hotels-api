package akadamia.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

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


  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("postalAddress", postalAddress)
        .append("email", email)
        .append("phone", phone)
        .append("url", url)
        .toString();
  }
}
