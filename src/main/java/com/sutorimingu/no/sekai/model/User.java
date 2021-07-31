package com.sutorimingu.no.sekai.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long user_id;
    private Boolean is_admin;
    private String username;
    private String password;
    private String email;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        final User user = (User) o;
        return Objects.equals(getUser_id(), user.getUser_id()) && Objects.equals(getIs_admin(), user.getIs_admin()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getIs_admin(), getUsername(), getPassword(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", is_admin=" + is_admin +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
