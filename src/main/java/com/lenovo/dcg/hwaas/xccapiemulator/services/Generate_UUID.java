package com.lenovo.dcg.hwaas.xccapiemulator.services;

import java.util.UUID;

public class Generate_UUID {
    private UUID uuid = UUID.randomUUID();
    private String randomUUIDString = uuid.toString();

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getRandomUUIDString() {
        return randomUUIDString;
    }
    public void setRandomUUIDString(String randomUUIDString) {
        this.randomUUIDString = randomUUIDString;
    }

    @Override
    public String toString() {
        return "Generate_UUID{" +
                "uuid=" + uuid +
                ", randomUUIDString='" + randomUUIDString + '\'' +
                '}';
    }
}