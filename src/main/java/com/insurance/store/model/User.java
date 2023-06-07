package com.insurance.store.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String name;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Vote> votes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> order; 
}
