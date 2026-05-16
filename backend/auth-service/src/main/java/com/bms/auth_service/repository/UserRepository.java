/*
 * Copyright (c) 2026. BookMySeat
 * All rights reserved.
 */

package com.bms.auth_service.repository;

import com.bms.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
