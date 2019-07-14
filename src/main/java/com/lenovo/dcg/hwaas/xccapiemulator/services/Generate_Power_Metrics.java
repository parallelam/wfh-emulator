package com.lenovo.dcg.hwaas.xccapiemulator.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

@Component
public class Generate_Power_Metrics {
    private String timeZone = "America/New_York";
    private Random random = new Random(System.nanoTime());
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    public String getTimeZone() {
        return timeZone;
    }
    public String generatePowerMeteringData(int maxValue, int minValue, int count, boolean minMax, String name) throws JSONException {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.SECOND, 0);
        date.add(Calendar.SECOND, 30);
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
}
