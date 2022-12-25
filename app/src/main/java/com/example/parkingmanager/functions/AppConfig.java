package com.example.parkingmanager.functions;

import com.example.parkingmanager.PakingManagerApplication;

public class AppConfig {
    public static String savePath = "/storage/emulated/0/ParkingManager/";
    public static String subFolder = "parking_record";
    public static int timeToPreviewInt = 5;
    public static Long timeToPreview = Long.valueOf(timeToPreviewInt*1000);

    public AppConfig(PakingManagerApplication application) {
        readFromSharedPrefs(application);
    }

    public void readFromSharedPrefs(PakingManagerApplication application) {
        EncSharedPrefs encSharedPrefs = new EncSharedPrefs(application);
        AppConfig.savePath = encSharedPrefs.getStringWithDefault("savePath", AppConfig.savePath);
    }
}
