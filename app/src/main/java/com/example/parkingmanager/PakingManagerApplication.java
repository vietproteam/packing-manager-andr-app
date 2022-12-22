package com.example.parkingmanager;

import android.app.Application;

import com.example.parkingmanager.entities.SuperUser;
import com.example.parkingmanager.entities.User;

public class PakingManagerApplication extends Application {

    private SuperUser superUser;
    private User user;

    public SuperUser getSuperUser() {
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
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
