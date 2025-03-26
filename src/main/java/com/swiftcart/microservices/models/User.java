package com.swiftcart.microservices.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 15)
    private String firstName;

    @Nullable
    String middleName;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 15)
    String lastName;

    @NotNull
    @NotBlank
    String password;

    boolean isDeleted;

    @ColumnDefault("true")
    boolean isActive;

    boolean isExpired;
    boolean isLocked;

    Integer invalidAttemptCount;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime passwordUpdateDate;
}
