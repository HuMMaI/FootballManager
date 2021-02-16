package dmytro.kudriavtsev.footballmanager.repos;

import dmytro.kudriavtsev.footballmanager.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
