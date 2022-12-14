package Project_desk.demo.Service;

import Project_desk.demo.DeskRepository.DeskRepository;
import Project_desk.demo.Model.Desk;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeskService implements DeskServiceInterface{

    private DeskRepository deskRepository;

    @Autowired
    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    @Override
    public Desk createDesk(Desk desk) {
        return this.deskRepository.save(desk);
    }

    @Override
    public Desk updateDesk(Desk deskUpd) {
        Desk desk = deskRepository.findById(deskUpd.getId()).get();

        desk.setPos_x(deskUpd.getPos_x());
        desk.setPos_y(deskUpd.getPos_y());
        return deskRepository.save(desk);
    }

    @Override
    public void deleteDesk(Long id) {
        this.deskRepository.deleteById(id);
    }

    @Override
    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }
}
