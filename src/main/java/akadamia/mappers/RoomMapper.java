package akadamia.mappers;

import akadamia.models.dao.Room;
import akadamia.models.dto.RoomDTO;
import akadamia.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomDTO> {

  @Override
  public RoomDTO map(Room from) {
    return RoomDTO
        .builder()
        .bed(from.getBed())
        .capacity(from.getCapacity())
        .type(from.getType())
        .build();
  }

  @Override
  public Room revers(RoomDTO to) {
    return null;
  }
}
