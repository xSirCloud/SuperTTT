package gerspach.superttt;


import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Json_Test {

    static String path = "H:\\SuperTTT_JSON_Test\\JSON_Test.json";
    static JsonArray turns = new JsonArray();

    public static void addMove(int subGridId, int fieldId) {
        JsonObject turn = new JsonObject();
        turn.add("SubGrid", new JsonPrimitive(subGridId));
        turn.add("FieldId", new JsonPrimitive(fieldId));
        turns.add(turn);


    }

    public static void saveFile() throws IOException {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(turns, writer);
        }
    }
}
