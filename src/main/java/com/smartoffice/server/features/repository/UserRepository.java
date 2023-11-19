package com.smartoffice.server.features.repository;

import com.smartoffice.server.database.entity.users.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserData, Long> {
    UserData findByEmail(String email);
}

