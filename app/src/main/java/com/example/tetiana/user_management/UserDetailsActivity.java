package com.example.tetiana.user_management;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.InputStream;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details_activity);
        TextView textView = (TextView) findViewById(R.id.user_detailed_name);

        try {
            InputStream inputStream = getAssets().open("user-details.json");
            UserRepository userRepository = new UserRepository(inputStream);
            int userId = getIntent().getIntExtra("userId", -1);
            User user =  userRepository.findUsersById(userId);
            textView.setText(user.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
