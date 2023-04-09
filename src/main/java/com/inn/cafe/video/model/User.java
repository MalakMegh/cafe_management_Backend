package com.inn.cafe.video.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@Table(name = "_user")
public class User implements UserDetails {

  public static final String ID               = "id";
  public static final String NAME             = "name";
  public static final String CONTACT_NUMBER   = "contact_number";
  public static final String EMAIL            = "email";
  public static final String PASSWORD         = "password";
  public static final String STATUS           = "status";
  public static final String ROLE             = "role";
  @Id
  @GeneratedValue
  @Column(name = ID)                          private Integer id;
  @Column(name = NAME)                        private String name;
  @Column(name = CONTACT_NUMBER)              private String contactNumber;
  @Column(name = EMAIL)                       private String email;
  @Column(name = PASSWORD)                    private String password;
  @Column(name = STATUS)                      private String status;
  @Enumerated(EnumType.STRING)
  @Column(name = ROLE)                        private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public String getPassword()  {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
