package com.swiftcart.microservices.models.users;

import com.swiftcart.microservices.models.orders.Orders;
import com.swiftcart.microservices.models.products.ProductReview;
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
import java.util.Set;
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
    private String middleName;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 15)
    private String lastName;

    @NotNull
    @NotBlank
    private String password;

    private Boolean isDeleted;

    @ColumnDefault("true")
    private Boolean isActive;

    private Boolean isExpired;
    private Boolean isLocked;
    private Boolean isSeller;
    private Boolean isCustomer;

    private Integer invalidAttemptCount;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime passwordUpdateDate;

    //No cascading required because role is an entity which can exist on its own
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;


    //OrphanRemoval is true, because if user remove any address from its collection then it must be removed from the db
    //Don't think address should have a reference of the user
    //Cascade all because if user is deleted then its address must be deleted
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Address> addresses;

    //once ordered then order can't be removed from history, that's why orphan removal is not true
    //Bi directional bcz user data must be fetched by using user reference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Orders> orders;

    //once reviewed then review can't be removed from history, that's why orphan removal is not true
    //Bi directional bcz user data must be fetched by using user reference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ProductReview> productReviews;
}
