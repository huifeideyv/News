package com.yangbangwei.news.Dao;


import com.yangbangwei.news.POJO.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from user where user_name=#{username}")
    List<User> findByUserName(String username);
}
