package dmytro.kudriavtsev.footballmanager.repos;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Statement s WHERE s.footballer.id = :footballerId")
    void deleteByFootballerId(@Param("footballerId") int footballerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Statement s WHERE s.team.id = :teamId")
    void deleteByTeamId(@Param("teamId") int teamId);

    @Query("SELECT COUNT(s.team) FROM Statement s")
    int countByTeamId(@Param("teamId") int teamId);

    @Query("SELECT s FROM Statement s WHERE s.team.id = :teamId")
    List<Statement> findAllByTeamId(@Param("teamId") int teamId);

    @Query("SELECT s FROM Statement s WHERE s.team IS NULL")
    List<Statement> findAllWithoutTeam();

    @Query("SELECT s FROM Statement s WHERE s.footballer.id = :footballerId")
    Statement findByFootballerId(@Param("footballerId") int footballerId);

    @Query("SELECT s FROM Statement s WHERE s.team IS NOT NULL AND s.team.id <> :teamId")
    List<Statement> findAllOtherPlayers(@Param("teamId") int teamId);
}
