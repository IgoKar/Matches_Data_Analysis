package com.sportdata.task.data;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonDataDeserializer {

    public static JsonData deserialize() {
        return deserialize("matches_data.json");
    }
    public static JsonData deserialize(String filename) {
        try{

            JsonReader reader = new JsonReader(new FileReader(filename));
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonData.class);

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found!");
            return null;
        }
    }
}
