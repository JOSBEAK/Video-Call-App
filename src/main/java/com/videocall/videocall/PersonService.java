package com.videocall.videocall;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PersonService {

    private static final List<Person> USERS_LIST = new ArrayList<>();

    public void register(Person person) {
        person.setStatus("online");
        USERS_LIST.add(person);
    }

    public Person login(Person user) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found"));
        var cUser = USERS_LIST.get(userIndex);
        if (!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }

    public void logout(String email) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found"));
        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public List<Person> findAll() {
        return USERS_LIST;
    }
}
