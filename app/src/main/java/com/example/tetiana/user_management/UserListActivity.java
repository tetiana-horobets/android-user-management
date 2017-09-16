package com.example.tetiana.user_management;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        TableLayout table = (TableLayout) findViewById(R.id.user_list_layout);

        try {
            InputStream inputStream = getAssets().open("users.json");
            UserRepository userRepository = new UserRepository(inputStream);

            for (User user : userRepository.findAll()) {
                TableRow row = new TableRow(this);
                TextView textView = new TextView(this);
                textView.setText(user.getName());
                row.addView(textView);
                table.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
