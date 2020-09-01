package com.hamming.ptf.util;

public class UUIDGenerator {
    private static UUIDGenerator instance = null;

    private UUIDGenerator() {
    }

    public static UUIDGenerator getInstance() {
        if (instance == null) {
            instance = new UUIDGenerator();
        }
        return instance;
    }

    public String generateUUID() {
        UUID newUUID= new UUID();
        return newUUID.toString();
    }
}
