package com.project.medicumzone.io.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfo {

    private String firstName;
    private String lastName;
    private String userName;
    private Object roles;

}
