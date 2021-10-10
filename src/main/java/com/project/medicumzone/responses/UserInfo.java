package com.project.medicumzone.responses;

import lombok.AllArgsConstructor;
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
