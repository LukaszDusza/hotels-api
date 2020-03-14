package akadamia.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String city;
  private String street;
  private String streetNo;
  @Email
  private String email;
  private String phone;
  private String url;

  @JsonIgnore
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hotel_id")
  private Hotel hotel;

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("city", city)
        .append("street", street)
        .append("streetNo", streetNo)
        .append("email", email)
        .append("phone", phone)
        .append("url", url)
        .append("hotel", hotel)
        .toString();
  }
}
