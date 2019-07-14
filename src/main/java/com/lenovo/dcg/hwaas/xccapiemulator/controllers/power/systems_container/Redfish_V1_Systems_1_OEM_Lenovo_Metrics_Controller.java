package com.lenovo.dcg.hwaas.xccapiemulator.controllers.power.systems_container;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Redfish_V1_Systems_1_OEM_Lenovo_Metrics_Controller {
    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics", produces = MediaType.APPLICATION_JSON_VALUE)
    public String Metrics() {
        return "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\",\"Name\":\"Historical Metrics\"," +
                "\"@odata.context\":\"\\/redfish\\/v1\\/$metadata#LenovoHistoryMetricValueContainerCollection.LenovoHistoryMetricValueContainerCollection\"," +
                "\"Members\":[{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/SystemInputPower\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/SystemOutputPower\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/CPUSubsystemPower\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/MemorySubsystemPower\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/PowerSupplyInputPower1\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/PowerSupplyInputPower2\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/PowerSupplyOutputPower1\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/PowerSupplyOutputPower2\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/SystemPerformance\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/CPUSubsystemPerformance\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/MemorySubsystemPerformance\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/IOSubsystemPerformance\"}," +
                "{\"@odata.id\":\"\\/redfish\\/v1\\/Systems\\/1\\/Oem\\/Lenovo\\/Metrics\\/InletAirTemp\"}]," +
                "\"@odata.type\":\"#LenovoHistoryMetricValueContainerCollection.LenovoHistoryMetricValueContainerCollection\"," +
                "\"@odata.etag\":\"\\\"ef459ef0f1904e93b3b0cc88c2c23b74\\\"\"," +
                "\"Members@odata.count\":13," +
                "\"Description\":\"A collection of HistoryMetricValueContainer resource instances.\"}";
    }
}
