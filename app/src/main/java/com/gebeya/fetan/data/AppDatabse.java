package com.gebeya.fetan.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.gebeya.fetan.data.dao.RunDao;
import com.gebeya.fetan.data.model.Run;

public abstract class AppDatabse extends RoomDatabase {

    @Database(entities = {Run.class},version = 1)
    public abstract class AppDatabase extends RoomDatabase{

        public abstract RunDao runDao();
    }

}
