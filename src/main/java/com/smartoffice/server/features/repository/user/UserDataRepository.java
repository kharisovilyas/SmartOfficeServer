package com.smartoffice.server.features.repository.user;

import com.smartoffice.server.database.entity.users.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {
    UserData findByEmail(String email);
}