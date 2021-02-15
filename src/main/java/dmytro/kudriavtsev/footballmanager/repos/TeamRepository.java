package dmytro.kudriavtsev.footballmanager.repos;

import dmytro.kudriavtsev.footballmanager.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public class TeamRepository extends JpaRepository<Team, Integer> {
}
