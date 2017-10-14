package searchworks.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import searchworks.model.Event;

public interface eventsRepo extends JpaRepository<Event, Integer> {

}
