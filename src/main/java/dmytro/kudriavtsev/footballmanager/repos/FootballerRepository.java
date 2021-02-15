package dmytro.kudriavtsev.footballmanager.repos;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

public class FootballerRepository extends JpaRepository<Footballer, Integer> {
}
