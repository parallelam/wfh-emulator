package com.lenovo.dcg.hwaas.xccapiemulator.models.responses.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class API_Storage_Volumes_UUID_Response {
  private String timeZone = "America/New_York";

  // Must be 12 digits 100,000,000,000 - Need to figure out random BigInt for
  // Java.
  public static int getRandomNumberInts(int min, int max) {
    Random random = new Random();
    return random.ints(min, (max + 1)).findFirst().getAsInt();
  }

  public String generateVolumesUUIDResponse(String uuid) {
    Calendar date = Calendar.getInstance();
    DateFormat tzConverter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX");
    tzConverter.setTimeZone(TimeZone.getTimeZone(timeZone));
    DateFormat localConverter = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss.SSS a");

    BigInteger size = new BigInteger(23, new Random());

    BigInteger space_size = new BigInteger(23, new Random());
    BigInteger space_available = new BigInteger(23, new Random());
    BigInteger space_used = new BigInteger(23, new Random());

    BigInteger latency_other = new BigInteger(23, new Random());
    BigInteger latency_total = new BigInteger(23, new Random());
    BigInteger latency_read = new BigInteger(23, new Random());
    BigInteger latency_write = new BigInteger(23, new Random());

    BigInteger iops_other = new BigInteger(23, new Random());
    BigInteger iops_total = new BigInteger(23, new Random());
    BigInteger iops_read = new BigInteger(23, new Random());
    BigInteger iops_write = new BigInteger(23, new Random());

    BigInteger throughput_other = new BigInteger(23, new Random());
    BigInteger throughput_total = new BigInteger(23, new Random());
    BigInteger throughput_read = new BigInteger(23, new Random());
    BigInteger throughput_write = new BigInteger(23, new Random());

    UUID aggregatesRandomId = UUID.randomUUID();
    String aggregatesRandomIdString = aggregatesRandomId.toString();
    UUID svmRandomId = UUID.randomUUID();
    String svmRandomIdString = svmRandomId.toString();
    Map links_hash = new LinkedHashMap();
    Map self_hash = new LinkedHashMap();
    Map tiering_hash = new LinkedHashMap();
    Map aggregates_hash = new LinkedHashMap();
    Map clone_hash = new LinkedHashMap();
    Map export_policy_hash = new LinkedHashMap();
    Map nas_hash = new LinkedHashMap();
    Map snapshot_policy_hash = new LinkedHashMap();
    Map svm_hash = new LinkedHashMap();
    Map space_hash = new LinkedHashMap();
    Map metric_hash = new LinkedHashMap();
    Map latency_hash = new LinkedHashMap();
    Map iops_hash = new LinkedHashMap();
    Map throughput_hash = new LinkedHashMap();
    Map item_root = new LinkedHashMap();

    tiering_hash.put("policy", "none");
    aggregates_hash.put("name", "DM5000H_03_1_SSD_1");
    // Random ID is Unique to other Random ID's in model:
    aggregates_hash.put("uuid", aggregatesRandomIdString);
    clone_hash.put("is_flexclone", false);
    export_policy_hash.put("name", "share_all");
    nas_hash.put("export_policy", export_policy_hash);
    snapshot_policy_hash.put("name", "none");
    svm_hash.put("name", "NFS");
    // Random ID is Unique to other Random ID's in model:
    svm_hash.put("uuid", svmRandomIdString);
    // BigInt needs to be the same as "size" variable bigint:
    space_hash.put("size", space_size);
    // BigInt must be less than the "size" variable bigint:
    space_hash.put("available", space_available);
    // BigInt must be less than the "size" variable bigint:
    space_hash.put("used", space_used);
    metric_hash.put("timestamp", localConverter.format(date.getTime()));
    metric_hash.put("duration", "PT15S");
    metric_hash.put("status", "ok");
    // Unsure of int parameters here:
    latency_hash.put("other", latency_other);
    // Unsure of int parameters here:
    latency_hash.put("total", latency_total);
    // Unsure of int parameters here:
    latency_hash.put("read", latency_read);
    // Unsure of int parameters here:
    latency_hash.put("write", latency_write);
    // Unsure of int parameters here:
    iops_hash.put("other", iops_other);
    // Unsure of int parameters here:
    iops_hash.put("total", iops_total);
    // Unsure of int parameters here:
    iops_hash.put("read", iops_read);
    // Unsure of int parameters here:
    iops_hash.put("write", iops_write);
    // Unsure of int parameters here:
    throughput_hash.put("other", throughput_other);
    // Unsure of int parameters here:
    throughput_hash.put("total", throughput_total);
    // Unsure of int parameters here:
    throughput_hash.put("read", throughput_read);
    // Unsure of int parameters here:
    throughput_hash.put("write", throughput_write);
    metric_hash.put("latency", latency_hash);
    metric_hash.put("iops", iops_hash);
    metric_hash.put("throughput", throughput_hash);
    // Random ID matches the URI called:
    self_hash.put("href", "/api/storage/volumes/" + uuid);
    links_hash.put("self", self_hash);

    // Random ID matches the URI called:
    item_root.put("uuid", uuid);
    item_root.put("comment", "");
    item_root.put("create_time", "2019-05-22T18:26:36+00:00");
    item_root.put("language", "c.utf_8");
    item_root.put("name", "NFS_1");
    item_root.put("size", size);
    item_root.put("state", "online");
    item_root.put("style", "flexvol");
    item_root.put("tiering", tiering_hash);
    item_root.put("type", "rw");
    item_root.put("aggregates", aggregates_hash);
    item_root.put("clone", clone_hash);
    item_root.put("nas", nas_hash);
    item_root.put("snapshot_policy", snapshot_policy_hash);
    item_root.put("svm", svm_hash);
    item_root.put("space", space_hash);
    item_root.put("metric", metric_hash);
    item_root.put("_links", links_hash);

    JSONObject response = new JSONObject(item_root);
    return response.toString();
  };
}
