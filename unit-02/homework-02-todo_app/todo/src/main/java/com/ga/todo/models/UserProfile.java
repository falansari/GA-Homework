package com.ga.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "profiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class UserProfile {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Setter
    private String firstName;

    @Column
    @Setter
    private String lastName;

    @Column
    @Setter
    private String profileDescription;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile", fetch = FetchType.LAZY)
    private User user;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
