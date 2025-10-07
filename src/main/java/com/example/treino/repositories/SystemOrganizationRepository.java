package com.example.treino.repositories;


import com.example.treino.models.SystemOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemOrganizationRepository extends JpaRepository<SystemOrganization, Long> {
    Optional<SystemOrganization> findByTittle(String title);
    Optional<List<SystemOrganization>> findAllOSByUserUserCode(String userCode);
}
