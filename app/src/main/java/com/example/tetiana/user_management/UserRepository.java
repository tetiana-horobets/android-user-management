package com.example.tetiana.user_management;


import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class UserRepository {

    private final InputStream inputStream;

    UserRepository(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    List<User> findAll() throws IOException {
        List<User> users = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        reader.beginObject();
        while (reader.hasNext()) {
            String propertyName = reader.nextName();
            if (propertyName.equals("users")) {
                reader.beginArray();
                while (reader.hasNext()) {
                    reader.beginObject();

                    try {
                        int id = Integer.parseInt(reader.nextName());
                        String name = reader.nextString();
                        users.add(new User(id, name));
                    } catch (NumberFormatException e) {
                        reader.skipValue();
                    }

                    reader.endObject();
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return users;
    }

    User findUsersById(int userId) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        List<User> users = readUsers(reader);
        for(User user: users) {
            if (userId == user.getId()) {
                return user;
            }
        }
        return null;
    }

    private List<User> readUsers(JsonReader reader) throws IOException {
        List<User> users = new ArrayList<>();
        reader.beginObject();
        String propertyName = reader.nextName();
        if (propertyName.equals("users")) {
            reader.beginArray();
            while (reader.hasNext()) {
                users.add(readUser(reader));
            }
            reader.endArray();
        } else {
            reader.skipValue();
        }
        reader.endObject();
        return users;
    }

    private User readUser(JsonReader reader) throws IOException {
        int id = -1;
        String name = null;
        String email = null;
        int age = -1;
        Boolean isFemale = true;
        List<String> hobbies = null;
        String image = null;
        String back = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            if (next.equals("id")) {
                id = reader.nextInt();
            } else if (next.equals("name")) {
                name = reader.nextString();
            } else if (next.equals("email")) {
                email = reader.nextString();
            } else if (next.equals("age")) {
                age = reader.nextInt();
            } else if (next.equals("isFemale")) {
                isFemale = reader.nextBoolean();
            } else if (next.equals("hobbies") && reader.peek() != JsonToken.NULL) {
                hobbies = readStringsArray(reader);
            } else if (next.equals("image")) {
                image = reader.nextString();
            } else if (next.equals("back")) {
                back = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new User(id, name, email, age, isFemale, hobbies, image, back);
    }

    private List<String> readStringsArray(JsonReader reader) throws IOException {
        List<String> strings = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            strings.add(reader.nextString());
        }
        reader.endArray();
        return strings;
    }
}
