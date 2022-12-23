package com.example.parkingmanager;

import android.app.Application;
import android.content.Intent;

import com.example.parkingmanager.activities.HomeActivity;
import com.example.parkingmanager.activities.LoginActivity;
import com.example.parkingmanager.entities.SuperUser;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.functions.EncSharedPrefs;

public class PakingManagerApplication extends Application {
    private EncSharedPrefs encSharedPrefs;
    private SuperUser superUser;
    private User user;

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
