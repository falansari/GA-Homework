package com.ga.todo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categories")
@Getter
public class Category {
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
    @CreationTimestamp
    private Timestamp createdAt;

    @Column
    @UpdateTimestamp
    private Timestamp updatedAt;
}
