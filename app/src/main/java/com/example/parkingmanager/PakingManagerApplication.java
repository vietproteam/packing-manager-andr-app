package com.example.parkingmanager;

import android.app.Application;
import android.content.res.Configuration;

import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Calculator;
import com.example.parkingmanager.entities.Card;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.Type;
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

    // init database for testing
    public void initDB(){
        AppDatabase db = AppDatabase.getInstance(this);

        // init positions
        db.positionDAO().insertPosition(new Position(1, "Admin"));
        db.positionDAO().insertPosition(new Position(2, "Manager"));
        db.positionDAO().insertPosition(new Position(3, "User"));

        // init users
        db.userDAO().insertUser(new User("Daniel", "nopass", "dan","1E88A063", db.positionDAO().getPositionById(1)));
        db.userDAO().insertUser(new User("Katy", "nopass", "kat","kkkkdhgdh", db.positionDAO().getPositionById(2)));
        db.userDAO().insertUser(new User("Mary", "nopass", "mar","kkkkdgfhdh", db.positionDAO().getPositionById(3)));
        db.userDAO().insertUser(new User("John", "nopass", "joh","kkkkdgfhdh", db.positionDAO().getPositionById(3)));

        // init calculator
        db.calculatorDAO().insertCalculator(new Calculator(1,"Option 1", "Something"));
        db.calculatorDAO().insertCalculator(new Calculator(2,"Option 2", "Something"));
        db.calculatorDAO().insertCalculator(new Calculator(3,"Option 3", "Something"));

        // init types
        db.typeDAO().insertType(new Type(1, "Car","Car",10000,db.calculatorDAO().getCalculatorById(1)));
        db.typeDAO().insertType(new Type(2, "Motorcycle","Motorcycle",5000,db.calculatorDAO().getCalculatorById(2)));
        db.typeDAO().insertType(new Type(3, "Truck","Truck",15000,db.calculatorDAO().getCalculatorById(3)));

        // init cards
        db.cardDAO().insertCard(new Card("1fdgdsfggfs", "Card 1", db.typeDAO().getTypeById(1)));
        db.cardDAO().insertCard(new Card("2fdgdsfggfs", "Card 2", db.typeDAO().getTypeById(2)));
        db.cardDAO().insertCard(new Card("3fdgdsfggfs", "Card 3", db.typeDAO().getTypeById(3)));
        db.cardDAO().insertCard(new Card("4fdgdsfggfs", "Card 4", db.typeDAO().getTypeById(1)));
        db.cardDAO().insertCard(new Card("5fdgdsfggfs", "Card 5", db.typeDAO().getTypeById(2)));
        db.cardDAO().insertCard(new Card("6fdgdsfggfs", "Card 6", db.typeDAO().getTypeById(3)));
        db.cardDAO().insertCard(new Card("7fdgdsfggfs", "Card 7", db.typeDAO().getTypeById(1)));

    }
}
