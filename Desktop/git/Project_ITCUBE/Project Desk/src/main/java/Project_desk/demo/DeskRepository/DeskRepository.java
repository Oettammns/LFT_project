package Project_desk.demo.DeskRepository;

import Project_desk.demo.Model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk,Long> {
}
