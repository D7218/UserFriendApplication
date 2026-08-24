package com.UserFriendApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "friends")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;
}
