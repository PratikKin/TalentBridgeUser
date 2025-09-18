package com.TalentBridgeUser.repository;

import com.TalentBridgeUser.model.AuthCredentials;
import com.TalentBridgeUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthCredentialsRepository extends JpaRepository<AuthCredentials, Long> {
    Optional<AuthCredentials> findByUser(User user);
}
