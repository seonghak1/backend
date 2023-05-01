package hyggy.backend.team.service;

import hyggy.backend.team.entity.UserTeam;
import hyggy.backend.team.repository.UserTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final UserTeamRepository userTeamRepository;

    @Autowired
    public TeamService(UserTeamRepository userTeamRepository) {
        this.userTeamRepository = userTeamRepository;
    }

    public void removeUserFromTeam(int userId, int teamId) {
        UserTeam userTeam = userTeamRepository.findByUserIdAndTeamId(userId, teamId);
        if (userTeam != null) {
            userTeamRepository.delete(userTeam);
        } else {
            throw new RuntimeException("User and team association not found");
        }
    }
}