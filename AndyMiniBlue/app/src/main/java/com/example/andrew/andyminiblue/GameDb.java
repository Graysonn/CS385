package com.example.andrew.andyminiblue;


        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

public class GameDb {

    //define the name of the columns
    public static final String KEY_ROWID = "GameID";
    public static final String KEY_WIN = "Win";
    public static final String KEY_LOSS = "Loss";



    private static final String TAG = "GameDb";
    //create a SQLite Database and a database helper
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    //define the database name and table name
    private static final String DATABASE_NAME = "GameScore";
    private static final String SQLITE_TABLE = "Win_and_Lose";
    private static final int DATABASE_VERSION = 9;

    private final Context mCtx;

    //method that creates a database, only creates the table if it doesn't exist
    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                    KEY_ROWID + " integer PRIMARY KEY," +
                    KEY_WIN  + " integer," +
                    KEY_LOSS + " integer);";


    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        //onCreate method that creates a database and adds in two rows
        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
            db.execSQL("INSERT INTO Win_and_Lose ("+KEY_ROWID+" , "+KEY_WIN+","+ KEY_LOSS+") values (0, 0, 0);");
            db.execSQL("INSERT INTO Win_and_Lose ("+KEY_ROWID+" , "+KEY_WIN+","+ KEY_LOSS+") values (1, 0, 0);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
            onCreate(db);
        }
    }

    public GameDb(Context ctx) {
        this.mCtx = ctx;
    }

    public GameDb open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public long createGame(int win, int loss ) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_WIN, win);
        initialValues.put(KEY_LOSS, loss);

        return mDb.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAll() {

        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_TABLE, null, null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }



    public String getWins() {
        Cursor c= mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID, KEY_WIN, KEY_LOSS}, KEY_ROWID + "=?", new String[] {String.valueOf(1)},null,null,null,null);

        //Move cursor to the first value and return the win value
        String ret="nope";
        if(c !=null) {
            c.moveToFirst();
            ret = c.getString(1);
        }
        return ret;
    }



    public String getLoss() {
        Cursor c= mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID, KEY_WIN, KEY_LOSS}, KEY_ROWID + "=?",new String[] {String.valueOf(1)}, null, null, null, null);

        //Move cursor to the first value and return the loss value
        String ret="nope";
        if(c !=null) {
            c.moveToFirst();
            ret = c.getString(2);
        }
        return ret;
    }

    //method that updates the table by incrementing the win value, note must close the cursor
    public void addWin(){
        Cursor c=mDb.rawQuery("UPDATE " + SQLITE_TABLE + " SET " + KEY_WIN + " = " + KEY_WIN + " +1", null);
        c.moveToFirst();
        c.close();
    }

    //method that updates the table by incrementing the Loss value, note must close the cursor
    public void addLoss(){
        Cursor c=mDb.rawQuery("UPDATE " + SQLITE_TABLE + " SET " + KEY_LOSS + " = " + KEY_LOSS + " +1", null);
        c.moveToFirst();
        c.close();
    }
}



