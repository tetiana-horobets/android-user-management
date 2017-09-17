package com.example.tetiana.user_management;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details_activity);
        TextView name = (TextView) findViewById(R.id.user_detailed_name);
        TextView email = (TextView) findViewById(R.id.user_detailed_email);
        TextView age = (TextView) findViewById(R.id.user_detailed_age);
        TextView isFemale = (TextView) findViewById(R.id.user_detailed_is_female);
        LinearLayout layoutHobby = (LinearLayout) findViewById(R.id.user_detailed_hobbies);
        ImageView image = (ImageView) findViewById(R.id.user_detailed_image);
        ImageView back = (ImageView) findViewById(R.id.user_detailed_back);

        try {
            InputStream inputStream = getAssets().open("user-details.json");
            UserRepository userRepository = new UserRepository(inputStream);
            int userId = getIntent().getIntExtra("userId", -1);
            User user =  userRepository.findUsersById(userId);
            name.setText(user.getName());
            email.setText(user.getEmail());
            age.setText(String.valueOf(user.getAge()));
            if (user.isFemale()){
                isFemale.setText("Female");
            } else {
                isFemale.setText("Male");
            }
            for(String hobby: user.getHobbies()){
                final TextView textView = new TextView(this);
                textView.setText(hobby);
                layoutHobby.addView(textView);
            }
            Picasso.with(this).load(user.getImage()).into(image);
            Picasso.with(this).load(user.getBack()).into(back);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
