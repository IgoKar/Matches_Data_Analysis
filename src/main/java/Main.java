import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import data.JsonData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("matches_data.json"));
        Gson gson = new Gson();

        JsonData data = gson.fromJson(reader, JsonData.class);
    }
}
