package com.lenovo.dcg.hwaas.xccapiemulator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

//import java.util.Date;

@RestController
public class XccController {
    // failRate_* percentage of time this error occurs;
    private int failRate_404;
    private int failRate_401;
    private int failRate_Empty;
    private String timeZone = "America/New_York";
    private Random random = new Random(System.nanoTime());

    public XccController() {
        this.failRate_401 = 0;
        this.failRate_404 = 0;
        this.failRate_Empty = 0;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    private String generateMeteringData(int maxValue, int minValue, int count, boolean minMax, String name) {
        Calendar date = Calendar.getInstance();
        DateFormat tzConverter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX");
        tzConverter.setTimeZone(TimeZone.getTimeZone(timeZone));
        DateFormat localConverter = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss.SSS a");
        JSONArray container = new JSONArray();

        for (short i = 0; i < count; i++) {
            int[] randomNumbers;
            JSONObject minEntry = new JSONObject();
            JSONObject maxEntry = new JSONObject();
            JSONObject avgEntry = new JSONObject();

            if (minMax) {
                randomNumbers = new int[3];
                for (int j = 0; j < 3; j++)
                    randomNumbers[j] = random.nextInt((maxValue + 1) - minValue) + minValue;
                Arrays.sort(randomNumbers);

                minEntry.put("Timestamp", localConverter.format(date.getTime()));
                minEntry.put("MetricValue", randomNumbers[0]);
                minEntry.put("Duration", "00:30");
                minEntry.put("MetricType", "Min");
                minEntry.put("TimestampWithTZ", tzConverter.format(date.getTime()));

                maxEntry.put("Timestamp", localConverter.format(date.getTime()));
                maxEntry.put("MetricValue", randomNumbers[2]);
                maxEntry.put("Duration", "00:30");
                maxEntry.put("MetricType", "Max");
                maxEntry.put("TimestampWithTZ", tzConverter.format(date.getTime()));

                avgEntry.put("Timestamp", localConverter.format(date.getTime()));
                avgEntry.put("MetricValue", randomNumbers[1]);
                avgEntry.put("Duration", "00:30");
                avgEntry.put("MetricType", "Avg");
                avgEntry.put("TimestampWithTZ", tzConverter.format(date.getTime()));

                container.put(minEntry);
                container.put(maxEntry);
                container.put(avgEntry);
            } else {
                randomNumbers = new int[1];
                randomNumbers[0] = random.nextInt((maxValue + 1) - minValue) + minValue;
                avgEntry.put("Timestamp", localConverter.format(date.getTime()));
                avgEntry.put("MetricValue", randomNumbers[0]);
                avgEntry.put("Duration", "00:30");
                avgEntry.put("MetricType", "Avg");
                avgEntry.put("TimestampWithTZ", tzConverter.format(date.getTime()));

                container.put(avgEntry);
            }
            date.add(Calendar.SECOND, -30);
        }

        JSONObject json = new JSONObject();
        json.put("Container", container);
        json.put("Id", name);
        json.put("Name", "Metric Value Container");
        json.put("@odata.context", "/redfish/v1/$metadata#LenovoHistoryMetricValueContainer.LenovoHistoryMetricValueContainer");
        json.put("TimeScope", "Previous_hour");
        json.put("@odata.type", "#LenovoHistoryMetricValueContainer.v1_0_0.LenovoHistoryMetricValueContainer");
        json.put("ContainerName", name);
        json.put("@odata.etag", "\"6ab47b7476d3b0039a8fd01dc7235f2d\"");
        json.put("@odata.id", "/redfish/v1/Systems/1/Oem/Lenovo/" + name);
        json.put("Description", "This resource is used to represent an array of history metric values in the container for a Redfish implementation.");

        return json.toString();
    }
    @RequestMapping(path = "/redfish/v1/Systems/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String System(){
        return "{\"SerialNumber\":\"J1001R64\",\"HostName\":\"Emulatorlenovocom\",\"SKU\":\"123456\"}";
    }
    //todo: get actual value ranges from API spec
    //todo: make random/dynamic
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

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/SystemInputPower", produces = MediaType.APPLICATION_JSON_VALUE)
    public String SystemInputPower() {
        return generateMeteringData(20, 15, 120, true, "SystemInputPower");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/SystemOutputPower", produces = MediaType.APPLICATION_JSON_VALUE)
    public String SystemOutputPower() {
        return generateMeteringData(15, 10, 120, true, "SystemOutputPower");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/MemorySubsystemPower", produces = MediaType.APPLICATION_JSON_VALUE)
    public String MemorySubsystemPower() {
        return generateMeteringData(0, 0, 120, true, "MemorySubsystemPower");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/PowerSupplyInputPower1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String PowerSupplyInputPower1() {
        return generateMeteringData(5, 5, 120, false, "PowerSupplyInputPower1");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/PowerSupplyInputPower2", produces = MediaType.APPLICATION_JSON_VALUE)
    public String PowerSupplyInputPower2() {
        return generateMeteringData(12, 13, 120, false, "PowerSupplyInputPower2");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/PowerSupplyOutputPower1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String PowerSupplyOutputPower1() {
        return generateMeteringData(0, 0, 120, false, "PowerSupplyOutputPower1");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/PowerSupplyOutputPower2", produces = MediaType.APPLICATION_JSON_VALUE)
    public String PowerSupplyOutputPower2() {
        return generateMeteringData(0, 0, 120, false, "PowerSupplyOutputPower2");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/SystemPerformance", produces = MediaType.APPLICATION_JSON_VALUE)
    public String SystemPerformance() {
        return generateMeteringData(0, 0, 120, true, "SystemPerformance");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/CPUSubsystemPerformance", produces = MediaType.APPLICATION_JSON_VALUE)
    public String CPUSubsystemPerformance() {
        return generateMeteringData(0, 0, 120, false, "CPUSubsystemPerformance");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/CPUSubsystemPower", produces = MediaType.APPLICATION_JSON_VALUE)
    public String CPUSubsystemPower() {
        return generateMeteringData(0, 0, 120, true, "CPUSubsystemPower");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/MemorySubsystemPerformance", produces = MediaType.APPLICATION_JSON_VALUE)
    public String MemorySubsystemPerformance() {
        return generateMeteringData(0, 0, 120, false, "MemorySubsystemPerformance");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/IOSubsystemPerformance", produces = MediaType.APPLICATION_JSON_VALUE)
    public String IOSubsystemPerformance() {
        return generateMeteringData(0, 0, 120, false, "IOSubsystemPerformance");
    }

    @RequestMapping(path = "/redfish/v1/Systems/1/Oem/Lenovo/Metrics/InletAirTemp", produces = MediaType.APPLICATION_JSON_VALUE)
    public String InletAirTemp() {
        return generateMeteringData(25, 25, 60, true, "InletAirTemp");
    }

    //todo: make random/dynamic
    @RequestMapping(path = "/redfish/v1/Managers/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String Managers() {
        Calendar date = Calendar.getInstance();
        DateFormat localConverter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        //localConverter.setTimeZone(TimeZone.getTimeZone(timeZone));
        return "{\n" +
                "  \"DateTimeLocalOffset\": \"-05:00\",\n" +
                "  \"Id\": \"1\",\n" +
                "  \"Links\": {\n" +
                "    \"ManagerForChassis\": [\n" +
                "      {\n" +
                "        \"@odata.id\": \"/redfish/v1/Chassis/1\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"ManagerForServers\": [\n" +
                "      {\n" +
                "        \"@odata.id\": \"/redfish/v1/Systems/1\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"ManagerType\": \"BMC\",\n" +
                "  \"@odata.context\": \"/redfish/v1/$metadata#Manager.Manager\",\n" +
                "  \"Model\": \"Lenovo XClarity Controller\",\n" +
                "  \"PowerState\": \"On\",\n" +
                "  \"NetworkProtocol\": {\n" +
                "    \"@odata.id\": \"/redfish/v1/Managers/1/NetworkProtocol\"\n" +
                "  },\n" +
                "  \"SerialInterfaces\": {\n" +
                "    \"@odata.id\": \"/redfish/v1/Managers/1/SerialInterfaces\"\n" +
                "  },\n" +
                "  \"SerialConsole\": {\n" +
                "    \"MaxConcurrentSessions\": 2,\n" +
                "    \"ConnectTypesSupported\": [\n" +
                "      \"IPMI\",\n" +
                "      \"SSH\"\n" +
                "    ],\n" +
                "    \"ServiceEnabled\": true\n" +
                "  },\n" +
                "  \"VirtualMedia\": {\n" +
                "    \"@odata.id\": \"/redfish/v1/Managers/1/VirtualMedia\"\n" +
                "  },\n" +
                "  \"Description\": \"This resource is used to represent a management subsystem for a Redfish implementation.\",\n" +
                "  \"@odata.id\": \"/redfish/v1/Managers/1\",\n" +
                "  \"Oem\": {\n" +
                "    \"Lenovo\": {\n" +
                "      \"Configuration\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/Configuration\"\n" +
                "      },\n" +
                "      \"FoD\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/FoD\"\n" +
                "      },\n" +
                "      \"RemoteMap\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/RemoteMap\"\n" +
                "      },\n" +
                "      \"Security\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/Security\"\n" +
                "      },\n" +
                "      \"ServiceData\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/ServiceData\"\n" +
                "      },\n" +
                "      \"DateTimeService\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/DateTimeService\"\n" +
                "      },\n" +
                "      \"@odata.type\": \"#LenovoManager.v1_0_0.LenovoManagerProperties\",\n" +
                "      \"Watchdogs\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/Watchdogs\"\n" +
                "      },\n" +
                "      \"RemoteControl\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/RemoteControl\"\n" +
                "      },\n" +
                "      \"ServerProfile\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/ServerProfile\"\n" +
                "      },\n" +
                "      \"RecipientsSettings\": {\n" +
                "        \"RetryCount\": 5,\n" +
                "        \"RetryInterval\": 0.5,\n" +
                "        \"RntryRetryInterval\": 0.5\n" +
                "      },\n" +
                "      \"Recipients\": {\n" +
                "        \"@odata.id\": \"/redfish/v1/Managers/1/Oem/Lenovo/Recipients\"\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"FirmwareVersion\": \"CDI334V 2.50 2019-03-19\",\n" +
                "  \"UUID\": \"6E716D6B-AE1E-11E7-A84E-9CE71DAAC05E\",\n" +
                "  \"Status\": {\n" +
                "    \"State\": \"Enabled\"\n" +
                "  },\n" +
                "  \"HostInterfaces\": {\n" +
                "    \"@odata.id\": \"/redfish/v1/Managers/1/HostInterfaces\"\n" +
                "  },\n" +
                "  \"Name\": \"Manager\",\n" +
                "  \"CommandShell\": {\n" +
                "    \"MaxConcurrentSessions\": 2,\n" +
                "    \"ConnectTypesSupported\": [\n" +
                "      \"SSH\"\n" +
                "    ],\n" +
                "    \"ServiceEnabled\": true\n" +
                "  },\n" +
                "  \"ServiceEntryPointUUID\": \"6E716D6B-AE1E-11E7-A84E-9CE71DAAC05E\",\n" +
                "  \"DateTime\": \""+ localConverter.format(date.getTime()) +"\",\n" +
                "  \"@odata.type\": \"#Manager.v1_5_0.Manager\",\n" +
                "  \"GraphicalConsole\": {\n" +
                "    \"MaxConcurrentSessions\": 6,\n" +
                "    \"ConnectTypesSupported\": [\n" +
                "      \"KVMIP\"\n" +
                "    ],\n" +
                "    \"ServiceEnabled\": true\n" +
                "  },\n" +
                "  \"LogServices\": {\n" +
                "    \"@odata.id\": \"/redfish/v1/Systems/1/LogServices\"\n" +
                "  },\n" +
                "  \"@odata.etag\": \"\\\"7bbe601e3c7b012547550ff1f3adff74\\\"\",\n" +
                "  \"Actions\": {\n" +
                "    \"#Manager.Reset\": {\n" +
                "      \"target\": \"/redfish/v1/Managers/1/Actions/Manager.Reset\",\n" +
                "      \"title\": \"Reset\",\n" +
                "      \"ResetType@Redfish.AllowableValues\": [\n" +
                "        \"GracefulRestart\",\n" +
                "        \"ForceRestart\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"EthernetInterfaces\": {\n" +
                "    \"@odata.id\": \"/redfish/v1/Managers/1/EthernetInterfaces\"\n" +
                "  }\n" +
                "}";
    }
}
