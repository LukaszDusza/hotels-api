package akadamia.mappers;

import akadamia.models.dao.Hotel;
import akadamia.models.dao.Room;
import akadamia.models.dto.HotelDTO;
import akadamia.models.dto.RoomDTO;
import akadamia.utils.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class HotelMapper implements Mapper<Hotel, HotelDTO> {

  private AddressMapper addressMapper;
  private RoomMapper roomMapper;

  public HotelMapper(AddressMapper addressMapper, RoomMapper roomMapper) {
    this.addressMapper = addressMapper;
    this.roomMapper = roomMapper;
  }

  @Override
  public HotelDTO map(Hotel from) {

    List<RoomDTO> rooms = from.getRooms()
        .stream()
        .map(roomMapper::map)
        .collect(Collectors.toList());

    return HotelDTO
        .builder()
        .title(from.getTitle())
        .country(from.getCountry())
        .rate(from.getRate())
        .address(addressMapper.map(from.getAddress()))
        .rooms(rooms)
        .build();
  }

  @Override
  public Hotel revers(HotelDTO to) {
    return null;
  }

  private enum RoomsToString implements Function<Room, String> {

    INSTANCE;

    @Override
    public String apply(Room room) {
      return room.toString();
    }
  }

}
