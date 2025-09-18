package com.TalentBridgeUser.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to User
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "uuid")
    private User user;

    @Column(nullable = false)
    private String passwordHash;
}
