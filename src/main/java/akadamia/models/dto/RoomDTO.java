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
public class RoomDTO {

  private String type;
  private String bed;
  private String capacity;

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("type", type)
        .append("bed", bed)
        .append("capacity", capacity)
        .toString();
  }
}
