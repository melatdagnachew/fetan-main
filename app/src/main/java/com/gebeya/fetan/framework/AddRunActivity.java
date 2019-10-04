package com.gebeya.fetan.framework;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.gebeya.fetan.R;
import com.gebeya.fetan.data.AppDatabase;
import com.gebeya.fetan.data.model.Run;
import com.gebeya.fetan.framework.base.BaseActivity;
import com.gebeya.fetan.framework.util.Const;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddRunActivity extends BaseActivity {

    @BindView(R.id.addRunDistanceEditText)
    EditText distanceEditText;

    @BindView(R.id.addRunTimeEditText)
    EditText timeEditText;

    private AppDatabase db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_run);

        ButterKnife.bind(this);

        db= Room.databaseBuilder(this, AppDatabase.class, Const.DATABASE_NAME).allowMainThreadQueries().build();
    }

    @OnClick(R.id.addRunSaveButton)
    public void saveRun(){

        Run run = new Run();

        double distance = Double.parseDouble(distanceEditText.getText().toString());
        int time = Integer.parseInt(timeEditText.getText().toString());
        String createedAt = new Date().toString();

        run.distance = distance;
        run.time=time;
        run.createdAt=createedAt;

        db.runDao().addRun(run);

        toast("Run saved!");
        finish();

    }
}