package com.example.libraryservicemanager.model;

import com.example.libraryservicemanager.Auditable.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserEntity extends Auditable {
    @Column(updatable = false, unique = true, nullable = false)
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean mfa;
    @JsonIgnore
    private String qrCodeSecret;
    @Column(columnDefinition = "text")
    private String qrCodeImgUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private RoleEntity role;

//    @JsonIgnore
//    @OneToMany(mappedBy = "user")
//    private List<BorrowedBooks> borrowedBooks = new ArrayList<>();
}
