package com.prokopovich.repository.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @Size(max = 20)
    @Pattern(regexp = "[a-zA-z]+")
    private String name;

    @NotNull
    @Size(max = 40)
    @Pattern(regexp = "[a-zA-z]+")
    @Column(name = "family")
    private String family;

    @NotNull
    @Size(max = 40)
    @Pattern(regexp = "[a-zA-z]+")
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "userRole")
    private UserRole userRole;
}

