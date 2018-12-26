package com.qwe.asd.controller;

import cn.base.entity.ChargeEntity;
import cn.base.entity.Users;
import com.qwe.asd.service.IDao;
import com.qwe.asd.service.SqlDemo;
import com.qwe.asd.service.TestService;
import com.qwe.asd.service.util;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Field;
import java.util.*;

@Controller
@RequestMapping("/spring")
public class TestController {
//   @Autowired
//   public IDao studentDAO;

   private String txt;

//    @Qualifier("test")
//    public TestService getTestService() {
//        return testService;
//    }

//    public void setTestService(TestService testService){
//        this.testService = testService;
//    }



    @RequestMapping("/helloworld")
    public String sayHello(@RequestParam("name") String name, Map<String,Object> model){
        //SqlDemo.getResult();
        Map map = new HashMap<String, String>();
        map.put("aa", "bb");
        model.put("axiba", "what the fuck");
        //this.test.sayHello();
        System.out.println(name);
        System.out.println(map);
        return "helloworld";
    }

    @RequestMapping("/wtf/{name}")
    public String what(@PathVariable("name") String username){
        System.out.println(username);
        return "what";
    }

    @ResponseBody
    @RequestMapping("/greet")
    public Map<String, Object> greet(@RequestParam(value = "name", defaultValue = "World") String name){
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<String> animals = new ArrayList<>();
        List<Map<String, Object>> list = util.fullToList(SqlDemo.getResult());
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Cat");
        animals.add("Dog");
        map.put("userName", animals);
        map.put("list", list);
        return map;
    }

    @ResponseBody
    @RequestMapping("/person")
    public Map<String, Object> getPerson(@RequestParam(value = "name", defaultValue = "World") String name){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        map.put("list", SqlDemo.getPerson());
        return map;
    }

    @ResponseBody
    @RequestMapping("/oneperson")
    public Map<String, Object> getOnePerson(@RequestParam(value = "name", defaultValue = "World") String name){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        map.put("list", SqlDemo.getOnePerson(name));
        return map;
    }

    @ResponseBody
    @RequestMapping("/lotteryInfo")
    public Map<String, Object> getLotteryInfo(@RequestParam(value = "name", defaultValue = "World") String name){
        if(name == null){
            System.out.println("empty");
        }
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "success");
        map.put("list", SqlDemo.getLottery());
        return map;
    }

    @ResponseBody
    @RequestMapping("/getRecordByDate")
    public Map<String, Object> getRecordByDate(@RequestParam(value = "begin") String begin, @RequestParam(value = "end") String end){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "success");
        map.put("list", SqlDemo.getRecordByDate(begin, end));
        return map;
    }

//    @ResponseBody
//    @RequestMapping("/getChargeRecord")
//    public Map<String, Object> getChargeRecord(@RequestParam(value = "begin") String begin, @RequestParam(value = "end") String end){
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("status", "success");
//        map.put("list", SqlDemo.getChargeRecord(begin, end));
//        return map;
//    }

    @ResponseBody
    @RequestMapping("/getChargeRecord")
    public Map<String, Object> getChargeRecord(ChargeEntity ch){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "success");
        //map.put("list", SqlDemo.getChargeRecord(begin, end));
        return map;
    }

    //Map<String, Object> mm
    @ResponseBody
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody Users user){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "success");
        System.out.println(user);

        System.out.println(user.getName());
        Map<String, Object> maps = reflect(user);


//        System.out.println(mm);
//        System.out.println(mm.get("title"));
//        System.out.println(mm.get("arr"));
//        List<String> list = (List)mm.get("arr");
//        for (String j : list) {
//            System.out.println(j);
//        }
        //map.put("list", SqlDemo.getRecordByDate(begin, end));
        return map;
    }


    @ResponseBody
    @RequestMapping(value="/test")
    public Map<String, Object> test(Users user){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "success");
        System.out.println(user);
        System.out.println(user.getName());
        return map;
    }



//    @ResponseBody 
//    //@RequestMapping(value="/save", method = RequestMethod.POST) 
//    @RequestMapping("/save") 
//    public String save(@RequestParam(value = "titles") String[] titles){ 
//       
//        return null; 
//    }
//获得所有属性数组
    public static Map<String, Object> reflect(Object host){
        Class cls = host.getClass();
        Field[] fields = cls.getDeclaredFields();
        Map<String, Object> map = new LinkedHashMap<>();
        for(int i = 0;i <fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);//设置属性可读
            try {
                System.out.println("host["+f.getName()+"] =  "+f.get(host));
                map.put(f.getName(), f.get(host));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


}
