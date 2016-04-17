package com.rental.service.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rental.dao.ActorDao;
import com.rental.model.Actor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:resources/META-INF/spring-persistence-unit.xml", "file:resources/META-INF/services-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class ActorServiceTest {

	@Autowired
	ActorDao actorDao;
	
	@Test
	public void testLoad(){
		Actor a = actorDao.load(1);
		Assert.assertNotNull(a);
		System.out.println(a);
	}
	
}
