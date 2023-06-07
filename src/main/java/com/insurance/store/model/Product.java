package com.insurance.store.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name ="products" )
public class Product extends BaseEntity {
    private String name;
    private String description;

    private boolean isVisible;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Comment> comments;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Vote> votes;

    @Enumerated(EnumType.STRING)
    private CommentVotePolicy commentPolicy;

    @Enumerated(EnumType.STRING)
    private CommentVotePolicy votePolicy;
    private String imageUrl;
}
