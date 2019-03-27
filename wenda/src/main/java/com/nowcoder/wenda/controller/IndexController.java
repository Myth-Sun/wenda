package com.nowcoder.wenda.controller;

import com.nowcoder.wenda.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
public class IndexController {

    @RequestMapping(path={"/","/index"})
    //返回字符串
    @ResponseBody
    public String index(){
        return "Hello Nowcoder";
    }

    @RequestMapping(path={"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId,
                          @RequestParam("type") int type,
                          @RequestParam(value = "key",defaultValue = "1",required = false) String key){
        return String.format("Profile Page of %s/%d,t:%d k:%s",groupId,userId,type,key);
    }

    @RequestMapping(path={"/vm"})
    public String template(Model model){
        model.addAttribute("value1","1111");
        List<String> colors= Arrays.asList(new String[]{"red","Green","Blue"});
        model.addAttribute("colors",colors);
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<4;++i){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);
        model.addAttribute("user",new User("Myth"));
        return "home";
    }
}
