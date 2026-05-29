// -- UserRepository.java --
package com.harinitech.springboot_security_jwt_rbac_app1.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harinitech.springboot_security_jwt_rbac_app1.entity.User;
import com.harinitech.springboot_security_jwt_rbac_app1.model.Status;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	List<User> findByStatus(Status status);
}