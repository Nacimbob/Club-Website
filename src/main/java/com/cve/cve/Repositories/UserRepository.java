package com.cve.cve.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cve.cve.Models.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>  {

    Boolean existsByUsername(String username);
    User findByUsername(String username);
}