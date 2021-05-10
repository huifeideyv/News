package com.yangbangwei.news.Service.Impl;

import com.yangbangwei.news.Dao.UserDao;
import com.yangbangwei.news.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       List<User> list=userDao.findByUserName(username);
       if(list==null) {
           throw  new UsernameNotFoundException("username is not exist");
       }
        User user= list.get(0);
        //System.out.println(user.getUser_name()+" "+user.getUser_passwd());
       return new org.springframework.security.core.userdetails.User(user.getUser_name(),user.getUser_passwd(), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getUser_authority()));
    }
}
