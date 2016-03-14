package com.example.juggernaut.database_insertion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by juggernaut on 14/3/16.
 */
public class JuggernautDatabaseAdapter {

    JuggernautHelper helper;
    public JuggernautDatabaseAdapter(Context context){
        helper = new JuggernautHelper(context);
    }

    public long insertData (String name, String password){
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(JuggernautHelper.NAME,name);
        contentValues.put(JuggernautHelper.PASSWORD, password);
        long id = database.insert(JuggernautHelper.TABLE_NAME,null,contentValues);
        return id;
    }

    public String loadData(){
        StringBuffer buffer = new StringBuffer();
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] coloumns = {JuggernautHelper.UID,JuggernautHelper.NAME,JuggernautHelper.PASSWORD};
        Cursor cursor = db.query(JuggernautHelper.TABLE_NAME, coloumns, null, null, null, null, null);
        while (cursor.moveToNext()){
            int cid = cursor.getInt(cursor.getColumnIndex(JuggernautHelper.UID));
            String name = cursor.getString(cursor.getColumnIndex(JuggernautHelper.NAME));
            String password = cursor.getString(cursor.getColumnIndex(JuggernautHelper.PASSWORD));
            buffer.append(cid+" "+name+" "+password+"\n");
        }

        return buffer.toString();
    }

    static class JuggernautHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "juggernautdatabase";
        private static final String TABLE_NAME = "JUGGERNAUTTABLE";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD = "Password";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+
                " VARCHAR(255), "+PASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXIST "+TABLE_NAME;
        private Context context;

        public JuggernautHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
                Message.Message("on create called", context);
                Log.d("juggernaut","on create called");
            } catch (SQLException e) {
                Message.Message(""+e,context);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Message.Message(""+e,context);
            }
        }
    }

}
