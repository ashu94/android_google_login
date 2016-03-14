package com.example.juggernaut.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by juggernaut on 14/3/16.
 */
public class JuggernautHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "juggernautdatabase";
    private static final String TABLE_NAME = "JUGGERNAUTTABLE";
    private static final int DATABASE_VERSION = 1;
    private static final String UID = "_id";
    private static final String NAME = "Name";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXIST"+TABLE_NAME;
    private Context context;


    public JuggernautHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Message.message(context,"Constructor was called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
            Message.message(context, "onCreate was called");
        } catch (SQLException e) {
            Message.message(context, ""+e);
            Log.d("juggernaut", String.valueOf(e));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Message.message(context, "on upgrade was called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context,""+e);
        }

    }
}
