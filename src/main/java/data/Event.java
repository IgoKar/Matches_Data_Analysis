package data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;


@Getter
public class Event {
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

    private List<Competitor> competitors;

    @Override
    public String toString() {
        return "Event{" +
                ", probabilityHomeTeamWinner=" + probabilityHomeTeamWinner +
                ", probabilityDraw=" + probabilityDraw +
                ", probabilityAwayTeamWinner=" + probabilityAwayTeamWinner +
                '}';
    }
}
