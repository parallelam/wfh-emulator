package com.lenovo.dcg.hwaas.xccapiemulator.controllers.power.systems_container.metrics_container;

import com.lenovo.dcg.hwaas.xccapiemulator.services.Generate_Power_Metrics;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Redfish_V1_Systems_1_OEM_Lenovo_Metrics_SystemOutputPower_Controller {
    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/SystemOutputPower", produces = MediaType.APPLICATION_JSON_VALUE)
    public String SystemOutputPower(Generate_Power_Metrics generate) throws JSONException {
        return generate.generatePowerMeteringData(999, 1, 120, true, "SystemOutputPower");
    }
}
