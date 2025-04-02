

package com.wdyapplications.pharmapp.dao.repository;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.repository.base._UsersRepository;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : Users.
 *
 * @author Geo
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, _UsersRepository {
    @Query("select e from Users e  WHERE (e.username LIKE %:search% OR e.email LIKE %:search%) and e.isDeleted = :isDeleted")
    List<Users> findExistingUsersFromSearch(@Param("search")String search, @Param("isDeleted")Boolean isDeleted);

}
