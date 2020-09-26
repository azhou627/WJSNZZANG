package com.wjsn.repositroy;

import com.wjsn.entity.DailyIncome;
import com.wjsn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/8/22 15:54
 * @description： 油管个人集资
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //按总额排序返回个人集资列表
    List<User> findAllByOrderByIncomeDesc();

    //修改个人集资
    @Transactional
    @Modifying
    @Query(value = "update user set income = income + ?2 where qq = ?1",nativeQuery = true)
    void updateByQq(String qq, Double income);

    User findByQq(String qq);


    //返回个人集资前10
    @Transactional
    @Modifying
    @Query(value = "select * from user order by income desc , qq desc limit 10",nativeQuery = true)
    List<User> getTop10();

}
