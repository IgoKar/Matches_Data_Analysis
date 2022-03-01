package com.sportdata.task.data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Venue {
    private String id;
    private String name;
    private long capacity;

    @SerializedName("city_name")
    private String cityName;
    @SerializedName("country_name")
    private String countryName;
    @SerializedName("map_coordinates")
    private String mapCoordinates;
    @SerializedName("country_code")
    private String countryCode;
}
