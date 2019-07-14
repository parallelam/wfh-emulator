package com.lenovo.dcg.hwaas.xccapiemulator.controllers.data;

import com.lenovo.dcg.hwaas.xccapiemulator.models.responses.data.API_Storage_Volumes_Response;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/storage/volumes/", produces = MediaType.APPLICATION_JSON_VALUE)
public class API_Storage_Volumes_Controller {

    private API_Storage_Volumes_Response response;

    public API_Storage_Volumes_Controller(API_Storage_Volumes_Response response) {
        this.response = response;
    }

    // Data Metering GET function:
    @GetMapping
    public String Volumes() throws JSONException {
        return response.generateVolumesResponse(9);
    };
}
