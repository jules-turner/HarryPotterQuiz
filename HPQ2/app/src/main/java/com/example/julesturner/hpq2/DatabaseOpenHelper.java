package com.example.julesturner.hpq2;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String HPQlol = "HarryPotterQuizLol3.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseOpenHelper(Context context) {
        super(context, HPQlol, null, DATABASE_VERSION);
    }
}