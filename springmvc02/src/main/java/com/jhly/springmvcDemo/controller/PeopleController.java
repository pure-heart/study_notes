package com.jhly.springmvcDemo.controller;

import com.jhly.springmvcDemo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/29
 * @Description:com.jhly.springmvcDemo.controller
 * @Version:1.0
 */
@Controller
public class PeopleController {
    @Autowired
    private People people;
    /**传参
    基本数据类型：默认保持与请求参数名一致
    不一致用@RequestParam接收，defaultValue属性可设置默认值,required属性约束必须要有参数
    对象类型：请求参数名与对象属性名一致
     */
    @RequestMapping("demo1")
    public String test01(String name,Integer age, People people, HttpServletRequest request){
        System.out.println("执行demo,"+people+" "+name+" "+age);
        request.setAttribute("username","火花");
        return "main.jsp";
    }
    @RequestMapping("demo2")
    public String test02(@RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "10") Integer pageSize){
        System.out.println("执行demo,pageNum="+pageNum+" pageSize= "+pageSize);
        return "main.jsp";
    }
    @RequestMapping("demo3")
    public String test03(@RequestParam(required = true) String str){
        System.out.println("执行demo,必须传参，否则报错，参数为："+str);
        return "main.jsp";
    }
    /**
     * 多个同名参数用list接收
     * @param hover
     * @return
     */
    @RequestMapping("demo4")
    public String test04(@RequestParam("hover") List<String> hover){
        System.out.println("执行demo,"+hover);
        return "main.jsp";
    }

    /**
     *restful传值方式
     * @PathVariable获取@RequestMapping中内容
     * @return
     */
    @RequestMapping("demo5/{id}/{name}")
    public String test05(@PathVariable("name") String name, @PathVariable("id") Integer id){
        System.out.println("执行demo,"+name+" "+id);
        return "/main.jsp";
    }

    /**
     *跳转方式
     * 默认的跳转方式为请求转发
     *设置返回值内容调整跳转方式：重定向(redirect:资源路径)、转发(forward:资源路径)
     *
     */
    @RequestMapping("demo6")
    public String test06(){
        return "redirect:/main.jsp";
    }

    /**
     * 配置完自定义视图解析器，如果资源路径前有跳转方式则不执行自定义视图解析器
     * @return
     */
    @RequestMapping("demo7")
    public String test07(){
        return "redirect:demo6";
    }

    /**
     *@ResponseBody将返回值转换为json格式同时方法不再跳转
     * @return
     */
    @RequestMapping(value = "demo8")
    @ResponseBody
    public People test08(){
        people.setAge(13);
        people.setName("阿尔托莉雅");
        return people;
    }

    /**
     * 作用域传值的方式
     * 原生Servlet、Model、Map、ModelAndView
     * @return
     */
    @RequestMapping("demo9")
    public String test09(Model model){
        people.setAge(13);
        people.setName("阿尔托莉雅");
        model.addAttribute("people",people);
//        int i = 5/0;
        System.out.println("controller demo9");
        return "main";
    }
}
