package com.yangbangwei.news.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private String  user_passwd;
    private String user_authority;
    private Date user_createdate;
}
