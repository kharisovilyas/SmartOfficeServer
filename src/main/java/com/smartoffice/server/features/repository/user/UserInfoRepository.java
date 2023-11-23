package com.smartoffice.server.features.repository.user;

import com.smartoffice.server.database.entity.users.UserData;
import com.smartoffice.server.database.entity.users.UserInfoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoData, Long> {
}
