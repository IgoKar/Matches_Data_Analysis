package com.sportdata.task.methods;

import com.sportdata.task.data.Competitor;
import com.sportdata.task.data.Event;
import com.sportdata.task.data.JsonData;
import com.sportdata.task.data.JsonDataDeserializer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;

@Getter
public class TeamNames {
    private final ArrayList<Competitor> uniqueTeamNames = new ArrayList<>();

    /**
     * methods.TeamNames constructor;
     * Retrieves unique teams from specified data file.
     */
    public TeamNames(){
        retrieveTeamsFromJson();
    }

    /**
     * Retrieving teams from events
     * and adding unique ones to the ArrayList
     * with the use of method addUniqueTeamNames
     *
     * @see #addUniqueTeamNames(Competitor, Competitor)
     */

    private void retrieveTeamsFromJson() {
        JsonData data = JsonDataDeserializer.deserialize();
        for(Event event : data.events) {
            Competitor team1 = event.getCompetitors().get(0);
            Competitor team2 = event.getCompetitors().get(1);
            addUniqueTeamNames(team1, team2);
        }
    }

    /**
     * Method to add teams into ArrayList, if not already added before.
     *
     * @param team1 first events team
     * @param team2 second events team
     */
    public void addUniqueTeamNames(Competitor team1, Competitor team2) {
        if(!uniqueTeamNames.contains(team1)) uniqueTeamNames.add(team1);
        if(!uniqueTeamNames.contains(team2)) uniqueTeamNames.add(team2);
    }

    /**
     * Method to retrieve all unique team name found in Json file in ascending sorted order(if isSorted == true).
     *
     * @param isSorted allows us to print sorted and unsorted list of teams
     */
    public ArrayList<Competitor> getUniqueTeamNames(boolean isSorted) {
        ArrayList<Competitor> copy = new ArrayList<>(uniqueTeamNames);
        if(isSorted) {
            Collections.sort(copy);
        }

        return copy;
    }
}
