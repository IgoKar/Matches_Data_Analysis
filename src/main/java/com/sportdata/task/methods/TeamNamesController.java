package com.sportdata.task.methods;

import com.sportdata.task.data.Competitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TeamNamesController {
    @RequestMapping("/getTeams")
    public ArrayList<Competitor> getBestMatches(@RequestParam boolean sorted) {

        TeamNames teamNames = new TeamNames();
        return teamNames.getUniqueTeamNames(sorted);
    }
}
