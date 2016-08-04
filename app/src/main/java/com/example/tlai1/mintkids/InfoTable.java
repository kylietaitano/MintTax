package com.example.tlai1.mintkids;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by tlai1 on 8/3/16.
 */
public class InfoTable {

    /* Info table in the database */
    public static final String DATABASE_TABLE_INFO = "info_table";

    /** Info table contains column names and IDs for database access. */
    public static final String CHILD_KEY_ID = "_id";
    public static final int CHILD_COL_ID = 0;

    public static final String NAME_KEY_TEXT = "name";
    public static final int NAME_COL_ID = CHILD_COL_ID + 1;

    public static final String ALLOWANCE_SET_AMOUNT_KEY_TEXT = "Allowance_Amount";
    public static final int ALLOWANCE_SET_AMOUNT_COL_ID = CHILD_COL_ID + 2;

    public static final String ALLOWANCE_FREQUENCY_KEY_TEXT = "Allowance_Frequency";
    public static final int ALLOWANCE_FREQUENCY_COL_ID = CHILD_COL_ID + 3;

    public static final String MAX_TAX_PERCENTAGE_KEY_TEXT = "Max_Tax_Percentage";
    public static final int MAX_TAX_PERCENTAGE_COL_ID = CHILD_COL_ID + 4;

    public static final String CURRENT_TAX_PERCENTAGE_KEY_TEXT = "Current_Tax_Percentage";
    public static final int CURRENT_TAX_PERCENTAGE_COL_ID = CHILD_COL_ID + 5;

    public static final String CURRENT_BALANCE_KEY_TEXT = "Current_Balance";
    public static final int CURRENT_BALANCE_COL_ID = CHILD_COL_ID + 6;

    public static final String TAX_REFUND_AMOUNT_KEY_TEXT = "Tax_Refund_Amount";
    public static final int TAX_REFUND_AMOUNT_COL_ID = CHILD_COL_ID + 7;

    public static final String SAVING_AMOUNT_KEY_TEXT = "Saving_Amount";
    public static final int SAVING_AMOUNT_COL_ID = CHILD_COL_ID + 8;


    /** SQLite database creation statement. Auto-increments IDs of inserted jokes.
     *  IDs are set after insertion into the database. */
    public static final String DATABASE_CREATE = "create table " + DATABASE_TABLE_INFO + " (" +
            CHILD_KEY_ID + " integer primary key autoincrement, " +
            NAME_KEY_TEXT	+ " text not null, " +
            ALLOWANCE_SET_AMOUNT_KEY_TEXT	+ " integer not null, " +
            ALLOWANCE_FREQUENCY_KEY_TEXT + " integer not null, " +
            MAX_TAX_PERCENTAGE_KEY_TEXT + " integer not null, " +
            CURRENT_TAX_PERCENTAGE_KEY_TEXT + " integer not null, " +
            CURRENT_BALANCE_KEY_TEXT + " integer default 0, " +
            TAX_REFUND_AMOUNT_KEY_TEXT + " integer default 0, " +
            SAVING_AMOUNT_KEY_TEXT + " integer default 0);";

    /** SQLite database table removal statement. Only used if upgrading database. */
    public static final String DATABASE_DROP = "drop table if exists " + DATABASE_TABLE_INFO;

    public static void onCreate(SQLiteDatabase database) {

		/* Open the database and create the table "joke_table" */
        database.execSQL(DATABASE_CREATE);
    }

    public static final String TAG = InfoTable.class.getName();
    /**
     * Upgrades the database to a new version.
     *
     * @param database
     * 					The database to upgrade.
     * @param oldVersion
     * 					The old version of the database.
     * @param newVersion
     * 					The new version of the database.
     */
    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(TAG, "onUpgrade: The Database is being updated from old version " + oldVersion +
                " to a new version " + newVersion);

		/* Get rid of the old table since the database is being upgraded */
        database.execSQL(DATABASE_DROP);

		/* Create a new table*/
        onCreate(database);
    }
}
