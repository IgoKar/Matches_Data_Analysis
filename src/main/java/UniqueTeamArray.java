import data.Competitor;
import data.Event;
import data.JsonData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;

@Getter
public class UniqueTeamArray {
    private final ArrayList<Competitor> uniqueTeamNames = new ArrayList<>();

    /**
     * UniqueTeamArray constructor;
     * Retrieves unique teams from specified data file.
     * @param data - data acquired from Json file
     */
    public UniqueTeamArray(JsonData data){
        retrieveTeamsFromJson(data);
    }

    /**
     * Retrieving teams from events
     * and adding unique ones to the ArrayList
     * with the use of method addUniqueTeamNames
     *
     * @param data Json file data
     * @see #addUniqueTeamNames(Competitor, Competitor)
     */

    private void retrieveTeamsFromJson (JsonData data) {
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
     * Method to print all unique team name found in Json file in ascending sorted order.
     *
     * @param isSorted allows us to print sorted and unsorted list of teams
     */
    public void printUniqueTeamNames(boolean isSorted) {

        if(isSorted) Collections.sort(uniqueTeamNames);

        for(Competitor team : uniqueTeamNames) {
            System.out.println(team.getName());
        }
    }
}
