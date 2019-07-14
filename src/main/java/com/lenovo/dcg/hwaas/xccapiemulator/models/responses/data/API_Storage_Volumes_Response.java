package com.lenovo.dcg.hwaas.xccapiemulator.models.responses.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class API_Storage_Volumes_Response {

    private String generateRecord() throws JSONException {
        UUID randomId = UUID.randomUUID();
        String randomIdString = randomId.toString();
        Map record_hash = new LinkedHashMap();
        Map links_hash = new LinkedHashMap();
        Map self_hash = new LinkedHashMap();

        self_hash.put("href", "/api/storage/volumes/" + randomIdString);
        links_hash.put("self", self_hash);

        record_hash.put("uuid", randomIdString);
        record_hash.put("name", "CIFS_root");
        record_hash.put("_links", links_hash);
        JSONObject record = new JSONObject(record_hash);
        return record.toString();
    };

    public String generateVolumesResponse(int maxRecords) {
        Map links_hash = new LinkedHashMap();
        Map self_hash = new LinkedHashMap();
        Map item_root = new LinkedHashMap();
        JSONArray records_array = new JSONArray();
        self_hash.put("href", "/api/storage/volumes/");
        links_hash.put("self", self_hash);
        for (short i = 0; i < maxRecords; i++) {
            String record = generateRecord();
            JSONObject item = new JSONObject(record);
            records_array.put(item);
        }
        item_root.put("records", records_array);
        item_root.put("num_records", maxRecords);
        item_root.put("_links", links_hash);
        JSONObject response = new JSONObject(item_root);

        return response.toString();
    };
}
