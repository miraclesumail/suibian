package com.qwe.asd.service;
import cn.base.entity.ChargeEntity;
import cn.base.entity.HibernateUtil;
import cn.base.entity.LotteryEntity;
import cn.base.entity.PersonEntity;
import org.hibernate.Session;

import java.sql.*;
import java.lang.*;
import java.util.List;
import java.util.Map;

public class SqlDemo {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";


    static final String USER = "root";
    static final String PASS = "root";
    static Connection conn = null;

    public static Connection getConnection(){
         if(conn != null){
             //Statement stmt = null;
             try{
                 //调用Class.forName()方法加载驱动程序
                 Class.forName("com.mysql.jdbc.Driver");
                 System.out.println("成功加载MySQL驱动！");

                 try {
                     conn = DriverManager.getConnection(DB_URL,USER,PASS);
                 } catch (SQLException e){
                     e.printStackTrace();
                 }
             }catch(ClassNotFoundException e1){
                 System.out.println("找不到MySQL驱动!");
                 e1.printStackTrace();
             }
         }
         return conn;
    }

    public static List getPerson(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<PersonEntity> personList = session.createQuery("select p from PersonEntity p").list();

        for(PersonEntity eachPerson : personList) {
            System.out.println(eachPerson);
        }

        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return personList;
    }

    public static List getLottery(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<LotteryEntity> lotteryList = session.createQuery("select l from LotteryEntity l").list();

        for(LotteryEntity eachPerson : lotteryList) {
            System.out.println(eachPerson);
        }

        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return lotteryList;
    }

    public static List getOnePerson(String name){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.name = :name").setString("name", name).list();

        for(PersonEntity eachPerson : personList) {
            System.out.println(eachPerson);
        }

        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return personList;
    }

    public static List getRecordByDate(String begin, String end){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<PersonEntity> personList = session.createQuery("select p from PersonEntity p where p.time between :date and :ceilDate").setParameter("date", java.sql.Date.valueOf(begin)).setParameter("ceilDate", java.sql.Date.valueOf(end)).list();

        for(PersonEntity eachPerson : personList) {
            System.out.println(eachPerson);
        }
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return personList;
    }

    public static List getChargeRecord(Map<String, Object> map) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "select c from ChargeEntity c";
        for(int i = 0; )

        @SuppressWarnings("unchecked")
        List<ChargeEntity> chargeList = session.createQuery("select c from ChargeEntity c where c.time between :date and :ceilDate").setParameter("date", java.sql.Date.valueOf(begin)).setParameter("ceilDate", java.sql.Date.valueOf(end)).list();

        for(ChargeEntity eachCharge : chargeList) {
            System.out.println(eachCharge);
        }
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return chargeList;
    }

    public static ResultSet getResult(){
        System.out.println(USER);
        System.out.println("---------");
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        try {
            stmt = conn.createStatement();

            System.out.print("成功连接到数据库！");
            sql = "SELECT * FROM qwe";
            rs = stmt.executeQuery(sql);

            //return rs;
        }catch (SQLException e){
                e.printStackTrace();
        }
        return rs;
//
//        try{
//            //调用Class.forName()方法加载驱动程序
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("成功加载MySQL驱动！");
//
//            try {
//                conn = DriverManager.getConnection(DB_URL,USER,PASS);
//                //创建一个Statement对象
//                stmt = conn.createStatement();
//
//                System.out.print("成功连接到数据库！");
//
//                //String sql;
//                sql = "SELECT * FROM qwe";
//                rs = stmt.executeQuery(sql);
//                System.out.println(rs.getMetaData().getColumnCount());
//                System.out.println(rs);
////                while(rs.next()){
////                    // 通过字段检索
////
////                    String url = rs.getString("qq");
////
////                    // 输出数据
////
////                    System.out.print(", 站点 URL: " + url);
////                    System.out.print("\n");
////                }
//                //conn.close();
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }catch(ClassNotFoundException e1){
//            System.out.println("找不到MySQL驱动!");
//            e1.printStackTrace();
//        }
//
//        System.out.println(rs);
//        return rs;
//        //Class.forName("com.mysql.jdbc.Driver");
//
//        // 打开链接
//       // System.out.println("连接数据库...");
    }



}
