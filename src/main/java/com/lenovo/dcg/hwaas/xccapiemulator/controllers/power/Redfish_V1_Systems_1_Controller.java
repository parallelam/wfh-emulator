package com.lenovo.dcg.hwaas.xccapiemulator.controllers.power;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Redfish_V1_Systems_1_Controller {
    @RequestMapping(path = "/redfish/v1/Systems/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String System(){
        return "{\"SerialNumber\":\"J1001R64\",\"HostName\":\"Emulatorlenovocom\",\"SKU\":\"123456\"}";
    }
}
