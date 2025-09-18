package com.TalentBridgeUser.repository;

import com.TalentBridgeUser.model.User;
import com.TalentBridgeUser.utils.constants.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(String id);
    Optional<User> findTopByRoleOrderByUserIdDesc(Role role);
}

