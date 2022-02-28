import data.Competitor;
import data.Event;
import data.JsonData;
import data.Venue;

import java.util.Collections;

public class MatchesAnalysis {

    public void getBestMatches (int eventsNum, JsonData data){

        if(eventsNum > data.events.size()) return;

        Collections.sort(data.events);
        for(int i = 0; i < eventsNum; i++) {
            Event currEvent = data.events.get(i);

            String date = currEvent.getStartDate();
            Competitor team1 = currEvent.getCompetitors().get(0);
            Competitor team2 = currEvent.getCompetitors().get(1);
            Venue venue = currEvent.getVenue();
            String result = currEvent.getResult();
            double resultProbability = currEvent.getMaxProbability();

            printBestMatches(date, team1, team2, venue, result, resultProbability);
        }
    }

    public String formatDate(String date){
        String day = date.substring(0,date.indexOf('T'));
        String hour = date.substring(date.indexOf('T') + 1, date.indexOf('+'));
        return day + " " + hour;
    }

    public String getWinner(Competitor team1, Competitor team2, String result) {
        if(team1.getQualifier().equals(result)) return team1.getName() + " Win";
        if(team2.getQualifier().equals(result)) return team2.getName() + " Win";
        return "Draw";
    }

    public void printBestMatches(String date, Competitor team1, Competitor team2,
                                   Venue venue, String result, double resultProbability) {

        System.out.println(
                "\nStart date: "
                + formatDate(date)
                + "\n"
                + team1.getName()
                + " (" + team1.getCountry() + ") vs. "
                + team2.getName()
                + " (" + team2.getCountry() +")"
                + "\n"
                + "Venue: "
                + venue.getName()
                + "\n"
                + "Highest probable result: "
                + getWinner(team1, team2, result)
                + " (" + resultProbability +")"
                + "\n____________________________________"
        );
    }

}
