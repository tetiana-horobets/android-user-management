package com.example.tetiana.user_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        TableLayout table = (TableLayout) findViewById(R.id.user_list_layout);

        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1, "Tania"));
        users.add(new User(2, "Alice"));
        users.add(new User(3, "Bob"));

        for (User user : users){
            TableRow row = new TableRow(this);
            TextView textView=new TextView(this);
            textView.setText(user.getName());
            row.addView(textView);
            table.addView(row);
        }
    }
}
