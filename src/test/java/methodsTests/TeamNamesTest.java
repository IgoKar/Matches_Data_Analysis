package methodsTests;

import com.sportdata.task.data.Competitor;
import com.sportdata.task.methods.TeamNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class TeamNamesTest {

    TeamNames teams;
    @BeforeEach()
    void init(){
        teams = new TeamNames();
    }

    @Test
    void returnOnlyUniqueNames() {
        HashSet<Competitor> uniqueTeams = new HashSet<>(teams.getUniqueTeamNames());
        assertEquals(teams.getUniqueTeamNames().size(), uniqueTeams.size());
    }


    @Test
    void tryToAddNotUniqueTeamTwice() {
        Competitor team = teams.getUniqueTeamNames().get(0);
        int sizeBefore = teams.getUniqueTeamNames().size();
        teams.addUniqueTeamNames(team, team);

        int sizeAfter = teams.getUniqueTeamNames().size();

        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    void tryToAdd1UniqueTeam() {
        Competitor team = teams.getUniqueTeamNames().get(0);
        Competitor newTeam = new Competitor();
        newTeam.setName("Added new unique test team.");
        int sizeBefore = teams.getUniqueTeamNames().size();

        teams.addUniqueTeamNames(team, newTeam);

        int sizeAfter = teams.getUniqueTeamNames().size();

        assertEquals(sizeBefore + 1, sizeAfter);
    }
}
