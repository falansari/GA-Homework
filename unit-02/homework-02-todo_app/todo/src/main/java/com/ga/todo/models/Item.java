package com.ga.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
@Entity
@Table(name = "items")
@Getter
public class Item {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Setter
    private String name;

    @Column
    @Setter
    private String description;

    @Column
    @Setter
    private LocalDate dueDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    @Setter
    private Category category;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column
    @CreationTimestamp
    private Timestamp createdAt;

    @Column
    @UpdateTimestamp
    private Timestamp updatedAt;
}
