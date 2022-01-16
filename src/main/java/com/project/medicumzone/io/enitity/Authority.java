package com.project.medicumzone.io.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "AUTH_AUTHORITY")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;

    public Authority(String roleCode, String roleDescription) {
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }


    @Override
    public String getAuthority() {
        return roleCode;
    }
}

