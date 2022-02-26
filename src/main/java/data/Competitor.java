package data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Competitor {
    private String id;
    private String name;
    private String country;
    private String abbreviation;
    private String qualifier;
    private String gender;

    @SerializedName("country_code")
    private String countryCode;

    private double winProbability;
}
