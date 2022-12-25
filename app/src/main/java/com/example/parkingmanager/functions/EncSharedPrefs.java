package com.example.parkingmanager.functions;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import com.example.parkingmanager.PakingManagerApplication;
import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.supers.SuperUser;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EncSharedPrefs {
    SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public EncSharedPrefs(PakingManagerApplication application) {
        editor = null;
        try {
            Context context = application.getApplicationContext();
            MasterKey mainKey = new MasterKey.Builder(context)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            sharedPreferences = EncryptedSharedPreferences
                    .create(
                            context,
                            String.valueOf(R.string.app_id),
                            mainKey,
                            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                    );

             editor = sharedPreferences.edit();

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public String getStringWithDefault(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, true);
    }

    //    Commit SuperUser
    public void setSuperUser(SuperUser superUser) {
        superUser.toMap().forEach((k, v) -> editor.putString(k, v.toString()));
        editor.commit();
    }

    //    Load SuperUser
    public SuperUser getSuperUser() {
        SuperUser superUser = new SuperUser();
        superUser.toMap().forEach((k, v) -> superUser.set(k, sharedPreferences.getString(k, null)));
        return superUser;
    }
}
