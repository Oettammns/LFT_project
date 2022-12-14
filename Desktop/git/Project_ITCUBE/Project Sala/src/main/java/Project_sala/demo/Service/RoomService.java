package Project_sala.demo.Service;

import Project_sala.demo.Model.Room;
import Project_sala.demo.RoomRepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoomService implements RoomServiceInterface{

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room roomUpd) {
        Room room = roomRepository.findById(roomUpd.getId()).get();

        room.setAddress(roomUpd.getAddress());
        room.setName(roomUpd.getName());
        return this.roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        this.roomRepository.deleteById(id);
    }

    @Override
    public List<Room> gellAllRooms() {
        return roomRepository.findAll();
    }
}
