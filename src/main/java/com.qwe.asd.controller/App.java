package com.qwe.asd.controller;
import cn.base.entity.HibernateUtil;
import cn.base.entity.PersonEntity;
import cn.base.entity.LotteryEntity;
import com.qwe.asd.service.TestDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {

    @Test
    public void testHello() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ft.setLenient(false);
        Date beginDate = null, endDate = null;
        try {
            beginDate = ft.parse("2018-12-08");
            endDate = ft.parse("2018-12-12");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date begin =java.sql.Date.valueOf("2018-12-08");
        Date end =java.sql.Date.valueOf("2018-12-12");

        @SuppressWarnings("unchecked")
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.name = :name").setString("name", "qqq").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.id < 10").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.name like ?").setString(0, "%www%").list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p order by p.id where p.time <= :time").setString("time", ft.format(new Date("2018-12-10"))).list();
        List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.time between :date and :ceilDate").setParameter("date", beginDate).setParameter("ceilDate", endDate).list();
        //List<PersonEntity> personList = session.createQuery("select p from PersonEntity p limit 3,5").list();
//        Query query = session.createQuery("select l from LotteryEntity l");
//        query.setFirstResult(2);
        //query.setMaxResults(2);
        //List<LotteryEntity> personList = query.list();
        for(PersonEntity eachPerson :personList) {
            System.out.println(eachPerson);
            System.out.println("aaaaaaaaaaa");
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
