package dataTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.sportdata.task.data.JsonDataDeserializer;


class JsonDataDeserializerTest {

    @Test
    @DisplayName("Check if default method with give .json file return JsonData object")
    void deserializeReturnNotNull(){
        assertNotNull(JsonDataDeserializer.deserialize());
    }

    @Test
    @DisplayName("Check if deserialize method wwill return null for bad 'filename' param")
    void deserializeFileNotFoundReturnNull(){
        assertNull(JsonDataDeserializer.deserialize(""));
    }
}