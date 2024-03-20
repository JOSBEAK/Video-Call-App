package com.videocall.videocall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class PersonController {
    private final PersonService service;

    @PostMapping("/register")
    public void register(@RequestBody Person person){
       service.register(person);
    }

    @PostMapping("/login")
    public Person login(@RequestBody Person person){
     return  service.login(person);
    }

    @PostMapping("/logout")
    public void logout(String email){
         service.logout(email);
    }
    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
