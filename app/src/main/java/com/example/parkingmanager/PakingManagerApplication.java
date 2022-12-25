package com.example.parkingmanager;

import android.app.Application;
import android.content.res.Configuration;

import com.example.parkingmanager.entities.supers.SuperUser;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.functions.AppConfig;
import com.example.parkingmanager.functions.EncSharedPrefs;

public class PakingManagerApplication extends Application {
    private EncSharedPrefs encSharedPrefs;
    private SuperUser superUser;
    private User user;
    public AppConfig appConfig;

    public SuperUser getSuperUser() {
        superUser = encSharedPrefs.getSuperUser();
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        encSharedPrefs.setSuperUser(superUser);
        this.superUser = superUser;
    }

    public EncSharedPrefs getEncSharedPrefs() {
        return encSharedPrefs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        encSharedPrefs = new EncSharedPrefs(this);
        appConfig = new AppConfig(this);
    }

    // Configuration for app
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
