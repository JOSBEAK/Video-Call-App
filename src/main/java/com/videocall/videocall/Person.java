package com.videocall.videocall;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String username;
    private String email;
    private String password;
    private String status;
}
