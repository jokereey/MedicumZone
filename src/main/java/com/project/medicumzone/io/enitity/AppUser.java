package com.project.medicumzone.io.enitity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @Length(min = 8)
    @NotBlank
    private String password;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @JsonFormat(pattern= "yyyy-MM-dd")
    private LocalDateTime dob;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private boolean enabled;
    @NotBlank
    private String PESEL;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "AUTH_USER_AUTHORITY",joinColumns = @JoinColumn(referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(referencedColumnName ="id" ))
    private List<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public AppUser(Long id, String name, String surname, String username, String password, String email, LocalDateTime dob, String phoneNumber, boolean enabled, String PESEL) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.PESEL = PESEL;
    }

    public AppUser(String name, String surname, String username, String password, String email, LocalDateTime dob, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public String username(){
        return  username;
    }
}
