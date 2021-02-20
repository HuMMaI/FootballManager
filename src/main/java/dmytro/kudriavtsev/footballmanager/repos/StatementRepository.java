package dmytro.kudriavtsev.footballmanager.repos;

import dmytro.kudriavtsev.footballmanager.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
