package com.TalentBridgeUser.repository;

import com.TalentBridgeUser.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {
//    Optional<Candidate> findByUser(User user);
    Optional<Candidate> findByCandId(String candId);
}

