package com.smart.multithread;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Service("scoreUserService")
public class ScoreService extends BaseService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd) {
        String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";
        jdbcTemplate.update(sql, toAdd, userName);
    }
}
