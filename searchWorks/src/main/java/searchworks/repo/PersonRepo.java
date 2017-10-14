package searchworks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import searchworks.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
