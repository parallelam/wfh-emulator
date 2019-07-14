package com.lenovo.dcg.hwaas.xccapiemulator.controllers.power;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class Redfish_V1_Managers_1_Controller {

    @RequestMapping(path = "/redfish/v1/Managers/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String Managers() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.SECOND, 0);
        date.add(Calendar.SECOND, 30);
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
