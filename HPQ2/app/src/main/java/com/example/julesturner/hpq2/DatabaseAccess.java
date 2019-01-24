package com.example.julesturner.hpq2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess extends MainActivity{
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

     // THESE ARE THE QUERIES
    public List<String> getId(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM HPQlol", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getQuestions(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Question FROM HPQlol WHERE num = " + QuestionNum +";", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getAnswer(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Answer FROM HPQlol WHERE num = " + QuestionNum +";", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getNA1(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT NA1 FROM HPQlol WHERE num = " + QuestionNum +";", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getNA2(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT NA2 FROM HPQlol WHERE num = " + QuestionNum +";", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getNA3(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT NA3 FROM HPQlol WHERE num = " + QuestionNum +";", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getNA4(int QuestionNum) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT NA4 FROM HPQlol WHERE num = " + QuestionNum +";", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
