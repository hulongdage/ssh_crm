package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

//≤‚ ‘hibernateøÚº‹
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
			@Resource(name="sessionFactory")
	private SessionFactory sf ;
	
		@Test
		//µ•∂¿≤‚ ‘hibernate
		public void fun1(){
			Configuration conf = new Configuration().configure();
			
			SessionFactory sf = conf.buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			//-------------------------------------------------
			User u = new User();
			
			u.setUser_code("rose");
			u.setUser_name("»‚Àø");
			u.setUser_password("1234");
			
			session.save(u);
			
			//-------------------------------------------------
			tx.commit();
			
			session.close();
			
			sf.close();
			
		}
		
		@Test
		//≤‚ ‘springπ‹¿ÌsessionFactory
		public void fun2(){
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			//-------------------------------------------------
			User u = new User();
			
			u.setUser_code("jack");
			u.setUser_name("Ω‹øÀ");
			u.setUser_password("1234");
			
			session.save(u);
			
			//-------------------------------------------------
			tx.commit();
			
			session.close();
			
		}
		@Resource(name="userDao")
		private UserDao ud;
		@Test
		//≤‚ ‘Dao Hibernateƒ£∞Â
		public void fun3(){
			
			User u = ud.getByUserCode("tom");
			
			System.out.println(u);
		}
		@Resource(name="userService")
		private UserService us;
		@Test
		//≤‚ ‘aop ¬ŒÒ
		public void fun4(){
			User u = new User();
			
			u.setUser_code("hqy");
			u.setUser_name("∫¬«ø”¬");
			u.setUser_password("1234");
			
			
			us.saveUser(u);
		}
		
}
