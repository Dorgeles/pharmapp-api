

package com.wdyapplications.pharmapp.dao.repository;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.repository.base._PharmacieRepository;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository : Pharmacie.
 *
 * @author Geo
 */
@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer>, _PharmacieRepository {

}
