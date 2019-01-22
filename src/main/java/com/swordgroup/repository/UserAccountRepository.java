package com.swordgroup.repository;


import com.swordgroup.entity.db.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository——用户账户.<br>
 *
 * @author menghao.
 * @version 2018/3/30.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

}
