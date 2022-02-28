package data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;


@Getter
public class Event implements Comparable<Event> {
    @SerializedName("sport_event_id")
    private String sportEventId;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("sport_name")
    private String sportName;
    @SerializedName("competition_name")
    private String competitionName;
    @SerializedName("competition_id")
    private String competitionId;
    @SerializedName("season_name")
    private String seasonName;
    @SerializedName("venue")
    private Venue venue;
    @SerializedName("probability_home_team_winner")
    private double probabilityHomeTeamWinner;
    @SerializedName("probability_draw")
    private double probabilityDraw;
    @SerializedName("probability_away_team_winner")
    private double probabilityAwayTeamWinner;

    private double maxProbability;

    private List<Competitor> competitors;

    /**
     * Overridden compare method for comparing event objects
     * by their highest probability end result.
     *
     * @param otherEvent second Event object used in comparison
     * @return Event object with bigger wind/draw/loss probability
     */
    @Override
    public int compareTo(Event otherEvent) {
        double max1 = Math.max(probabilityAwayTeamWinner,
                Math.max(probabilityDraw,probabilityHomeTeamWinner));
        double max2 = Math.max(otherEvent.probabilityAwayTeamWinner,
                Math.max(otherEvent.probabilityDraw,otherEvent.probabilityHomeTeamWinner));
        return Double.compare(max2, max1);
    }

    /**
     * Inform about most probable winner or match ended with draw.
     *
     * @return String notifying about winning team or draw result.
     */
    public String getResult(){
        double max = Math.max(probabilityAwayTeamWinner,
                Math.max(probabilityDraw,probabilityHomeTeamWinner));

        maxProbability = max;

        if(max == probabilityAwayTeamWinner) return "away";
        else if (max == probabilityHomeTeamWinner) return "home";

        return "draw";
    }
}
