package com.example.inbox10Awards.modules.authenticationModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthenticationRepository extends JpaRepository<AuthenticationEntity,String> {

   //AuthenticationEntity findByEmailIgnoreCaseContaining(String email);

    //boolean existsCarByModel(String model);

    AuthenticationEntity findByEmail(String email);

    boolean existsAuthenticationEntityByEmailAndPassword(String email,String password);

}
