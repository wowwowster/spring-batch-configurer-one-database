package com.swordgroup.repository;


import com.swordgroup.entity.db.WaterRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository——水表记录.<br>
 *
 * @author menghao.
 * @version 2018/3/31.
 */
@Repository
public interface WaterRecordRepository extends JpaRepository<WaterRecord, Integer> {
}
