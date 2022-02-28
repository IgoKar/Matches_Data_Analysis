package data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Competitor implements Comparable<Competitor>{
    /**
     * Data aquired from Json file
     */
    private String id;
    private String name;
    private String country;
    private String abbreviation;
    private String qualifier;
    private String gender;
    @SerializedName("country_code")
    private String countryCode;


    @Override
    public int compareTo(Competitor otherCompetitior) {
        return this.name.compareTo(otherCompetitior.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object otherCompetitor) {
        if(otherCompetitor instanceof Competitor){
            String otherCompetitorName = ((Competitor) otherCompetitor).getName();
            return this.name.equals(otherCompetitorName);
        }
        return false;
    }
}
