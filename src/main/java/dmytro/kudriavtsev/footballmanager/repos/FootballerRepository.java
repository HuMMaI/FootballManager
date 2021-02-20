package dmytro.kudriavtsev.footballmanager.repos;

import dmytro.kudriavtsev.footballmanager.dtos.FootballerGetDto;
import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
//    @Query("select f.id, f.firstName, f.lastName, f.age, f.experience, f.price, t.name from Footballer f " +
//            "inner join TeamFootballerMapping tf " +
//            "inner join Team t " +
//            "where tf.footballerId = f.id and t.id = tf.teamId")
//    List<FootballerGetDto> getAllPlayers();
}
