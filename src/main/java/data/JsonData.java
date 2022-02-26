package data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonData {
    @SerializedName("Events")
    public List<Event> events;
}
