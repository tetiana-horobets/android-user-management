package com.example.tetiana.user_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.InputStream;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        TableLayout table = (TableLayout) findViewById(R.id.user_list_layout);

        try {
            InputStream inputStream = getAssets().open("users.json");
            final UserRepository userRepository = new UserRepository(inputStream);

            for (final User user : userRepository.findAll()) {
                TableRow row = new TableRow(this);
                final TextView textView = new TextView(this);
                textView.setText(user.getName());
                textView.setPadding(20, 16, 16, 16);
                textView.setTextSize(18);
                textView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(UserListActivity.this, UserDetailsActivity.class);
                        intent.putExtra("userId", user.getId());
                        startActivity(intent);
                    }
                });
                row.addView(textView);
                row.setBackgroundResource(R.drawable.row_borders);
                table.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
