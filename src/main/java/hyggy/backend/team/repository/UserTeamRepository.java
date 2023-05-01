package hyggy.backend.team.repository;

import hyggy.backend.team.entity.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Integer> {
    UserTeam findByUserIdAndTeamId(int userId, int teamId);
}