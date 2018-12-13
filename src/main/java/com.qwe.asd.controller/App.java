package com.qwe.asd.controller;
import cn.base.entity.HibernateUtil;
import cn.base.entity.PersonEntity;
import com.qwe.asd.service.TestDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    @Test
    public void testHello() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.name = :name").setString("name", "qqq").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.id < 10").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.name like ?").setString(0, "%www%").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p order by p.id").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p limit 3,5").list();
        Query query = session.createQuery("select p from PersonEntity p");
        query.setFirstResult(2);
        //query.setMaxResults(2);
        List<PersonEntity> personList = query.list();
        for(PersonEntity eachPerson : personList) {
            System.out.println(eachPerson);
        }

        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

        public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        TestDao test= (TestDao) context.getBean("testDao");
//        test.say();
        //TestController testController = (TestController) context.getBean("testController");
        //testController.say();

//        PersonEntity person = new PersonEntity();
//        person.setId(185);
//        person.setName("搜搜索人5发");
//        System.out.println(person);
//        Session session = HibernateUtil.getSession();
//        Transaction tx = session.beginTransaction();
//        session.save(person);
//
//        tx.commit();
//        HibernateUtil.closeSession();

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.name = :name").setString("name", "qqq").list();

        for(PersonEntity eachPerson : personList) {
            System.out.println(eachPerson);
        }

        session.getTransaction().commit();
        HibernateUtil.closeSession();

    }
}
