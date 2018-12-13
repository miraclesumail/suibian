package com.qwe.asd.controller;

import com.qwe.asd.service.IDao;
import com.qwe.asd.service.SqlDemo;
import com.qwe.asd.service.TestService;
import com.qwe.asd.service.util;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
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


}
