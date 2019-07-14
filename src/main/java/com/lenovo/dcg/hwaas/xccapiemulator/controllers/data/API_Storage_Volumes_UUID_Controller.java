package com.lenovo.dcg.hwaas.xccapiemulator.controllers.data;

import com.lenovo.dcg.hwaas.xccapiemulator.models.responses.data.API_Storage_Volumes_UUID_Response;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api/storage/volumes/**", produces = MediaType.APPLICATION_JSON_VALUE)
public class API_Storage_Volumes_UUID_Controller {
    private API_Storage_Volumes_UUID_Response response;

    public API_Storage_Volumes_UUID_Controller(API_Storage_Volumes_UUID_Response response) {
        this.response = response;
    }

    private String Volumes(@PathVariable String pathid) throws JSONException {
        return response.generateVolumesUUIDResponse(pathid);
    };

    @GetMapping
    public String method(HttpServletRequest request) {
        String variable = request.getServletPath();
        return Volumes(variable);
    };

}
