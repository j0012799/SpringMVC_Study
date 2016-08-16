package ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ssm.po.Items;

/**
 * 处理器Handler开发
 * @author xuchao
 *
 */

//实现了Controller接口的"处理器"(Handler)才能被"处理器适配器"(HandlerAdapter)执行
public class ItemsController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	System.out.println("=========>进入Handler");
        //实际中是调用service查找数据库，查询商品列表，这里直接使用静态数据来模拟了
        List<Items> itemsList = new ArrayList<Items>();
        //向list中填充静态数据
        Items items_1 = new Items();
        items_1.setId(1);
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setId(2);
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iPhone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);
        
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        //相当于request的setAttribute，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.addObject("test", "TEST:::::");

        //指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        System.out.println("即将跳转到jsp视图");
        return modelAndView;
    }
}