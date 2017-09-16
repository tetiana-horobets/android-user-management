package com.example.tetiana.user_management;


import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class UserRepository {

    private final InputStream inputStream;

    UserRepository(InputStream inputStream) {
        this.inputStream  = inputStream;
    }

    List<User> findAll() throws IOException {
        List<User> users = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        reader.beginObject();
        reader.nextName();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            String id = reader.nextName();
            String name = reader.nextString();
            users.add(new User(name));
            reader.endObject();
        }
        reader.endArray();
        reader.endObject();
        return users;
    }
}
