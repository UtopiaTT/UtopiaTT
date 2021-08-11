package com.bw.kongchenliang.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bw.kongchenliang.db.DaoMaster;
import com.bw.kongchenliang.db.DaoSession;

public class SqlUtils {
    private static SqlUtils sqlUtils;
    private DaoSession daoSession;
    public static SqlUtils getInstance() {
        if (sqlUtils==null){
            synchronized (SqlUtils.class){
                if (sqlUtils==null){
                    sqlUtils=new SqlUtils();
                }
            }
        }
        return sqlUtils;
    }
    public DaoSession sqlutil(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "yk");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);

        daoSession = daoMaster.newSession();
        return daoSession;
    }
}
