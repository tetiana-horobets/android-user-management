package com.example.tetiana.user_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button buttonSend = (Button) findViewById(R.id.buttonSend);

        try {
            InputStream inputStream = getAssets().open("user-details.json");
            UserRepository userRepository = new UserRepository(inputStream);
            int userId = getIntent().getIntExtra("userId", -1);
            final User user =  userRepository.findUsersById(userId);
            name.setText(user.getName());
            email.setText(user.getEmail());
            age.setText(String.valueOf(user.getAge()));
            isFemale.setText(user.isFemale() ? "Female" : "Male");

            for(String hobby: user.getHobbies()){
                final TextView textView = new TextView(this);
                textView.setText(hobby);
                layoutHobby.addView(textView);
            }

            Picasso.with(this).load(user.getImage()).into(image);
            Picasso.with(this).load(user.getBack()).into(back);

            buttonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendEmail = new Intent(Intent.ACTION_SEND);

                    sendEmail.putExtra(Intent.EXTRA_EMAIL, user.getEmail());
                    sendEmail.setType("message/rfc822");

                    startActivity(Intent.createChooser(sendEmail, "Choose an Email client"));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
