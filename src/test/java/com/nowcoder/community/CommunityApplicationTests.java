package com.nowcoder.community;

import com.nowcoder.community.Dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
//要获取spring容器首先要继承ApplicationContextAware
class CommunityApplicationTests implements ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(CommunityApplicationTests.class);

	private ApplicationContext applicationContext;
//使用@Autowired能够自动从容器获取bean，Qualifier可以指定bean名称
	@Autowired
	@Qualifier("alphahibernate")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

//		AlphaDao alphaDao = applicationContext.getBean(AlphaDaoHibernateImpl.class);
		System.out.println(alphaDao.select());
		System.out.println(alphaService);

//		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

		logger.info("info log test");
		logger.error("error log test");
	}
}
