package com.nowcoder.community;

import com.nowcoder.community.Dao.DiscussPostMapper;
import com.nowcoder.community.Dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    private static final Logger logger = LoggerFactory.getLogger(MapperTests.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        System.out.println(userMapper.selectById(101));

        System.out.println(userMapper.selectByEmail("nowcoder101@sina.com"));

    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123123");
        user.setSalt("11111");
        user.setEmail("nosqww@ahu.edu.cn");
        user.setStatus(2);
        user.setType(1);
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateTest(){
        int rows = userMapper.updateStatus(150, 2);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://images.nowcoder.com/head/1050t.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "123456789");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> List = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : List){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);

        logger.debug("debug");
        logger.error("error");
    }
}
