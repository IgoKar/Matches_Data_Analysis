package com.sportdata.task.methods;


import com.sportdata.task.data.*;

import java.util.Collections;

public class ResultsAnalysis {

    public static String getBestMatches (int eventsNum){
        JsonData data = JsonDataDeserializer.deserialize();
        String result = "";

        if(data == null) return "Error: NullPointerException";
        if(eventsNum > data.events.size()) return "Error: Events num can't be > events number.";
        if(eventsNum <= 0) return "Error: Events num can't be <= 0.";

        Collections.sort(data.events);

        for(int i = 0; i < eventsNum; i++) {
            Event currEvent = data.events.get(i);

            String date = currEvent.getStartDate();
            Competitor team1 = currEvent.getCompetitors().get(0);
            Competitor team2 = currEvent.getCompetitors().get(1);
            Venue venue = currEvent.getVenue();
            String matchResult = currEvent.getResult();
            double resultProbability = currEvent.getMaxProbability();

            result += "\n" + (addBestMatch(date, team1, team2, venue, matchResult, resultProbability)) + "\n";
        }
        return result;
    }



    private static String formatDate(String date){
        String day = date.substring(0,date.indexOf('T'));
        String hour = date.substring(date.indexOf('T') + 1, date.indexOf('+'));
        return day + " " + hour;
    }

    private static String getWinner(Competitor team1, Competitor team2, String result) {
        if(team1.getQualifier().equals(result)) return team1.getName() + " Win";
        if(team2.getQualifier().equals(result)) return team2.getName() + " Win";
        return "Draw";
    }

    private static String addBestMatch(String date, Competitor team1, Competitor team2,
                                       Venue venue, String matchResult, double resultProbability) {

        return "Start date: "
                + formatDate(date)
                + "<br />"
                + team1.getName()
                + " (" + team1.getCountry() + ") vs. "
                + team2.getName()
                + " (" + team2.getCountry() +")"
                + "<br />"
                + "Venue: "
                + venue.getName()
                + "<br />"
                + "Highest probable result: "
                + getWinner(team1, team2, matchResult)
                + " (" + resultProbability +")"
                + "<br /><br />";
    }
}
