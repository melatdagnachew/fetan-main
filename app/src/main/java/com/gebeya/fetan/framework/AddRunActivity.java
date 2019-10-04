package com.gebeya.fetan.framework;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.gebeya.fetan.R;
import com.gebeya.fetan.data.AppDatabse;
import com.gebeya.fetan.framework.base.BaseActivity;
import com.gebeya.fetan.framework.util.Const;

public class AddRunActivity extends BaseActivity {

    EditText distanceEditText;

    EditText timeEditText;

    private AppDatabse db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_run);

        db= Room.databaseBuilder(this,AppDatabse.class, Const.DATABASE_NAME).build();
    }
}