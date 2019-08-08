package com.example.inbox10Awards.modules.registrationModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RegistrationRepository extends JpaRepository<UserEntity,String> {
}
