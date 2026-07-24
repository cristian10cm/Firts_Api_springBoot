package com.cruz.medicaments_api.users.repository;

import com.cruz.medicaments_api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
