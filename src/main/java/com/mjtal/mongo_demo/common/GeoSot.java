package com.mjtal.mongo_demo.common;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface GeoSot extends Library {
    GeoSot INSTANCE = Native.load("GeoSOTForJava", GeoSot.class);

    String getHexCode(double lat, double lon, double height, int level);

    void freeMemory(String code);
}
