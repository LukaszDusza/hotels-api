package akadamia.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String type;
  private String bed;
  private String capacity;

  @JsonIgnore
  @ManyToMany(mappedBy = "rooms")
  private List<Hotel> hotels;

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("type", type)
        .append("bed", bed)
        .append("capacity", capacity)
        .append("hotels", hotels)
        .toString();
  }
}
