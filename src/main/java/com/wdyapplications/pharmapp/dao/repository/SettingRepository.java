

package com.wdyapplications.pharmapp.dao.repository;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.repository.base._SettingRepository;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Setting.
 *
 * @author Geo
 */
@Repository
public interface SettingRepository extends JpaRepository<Setting, Integer>, _SettingRepository {

}
