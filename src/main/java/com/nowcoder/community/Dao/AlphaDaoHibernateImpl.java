package com.nowcoder.community.Dao;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;
//访问数据库的类，用@Repository标识，spring会自动扫描装入容器
@Repository("alphahibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
