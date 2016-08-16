package ssm.controller;

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.HttpRequestHandler;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.po.Items;

/**
 * 处理器Handler开发：用第二种处理器适配器，比较两者的区别
 * 				  换成注解的方式，前面都是基于非注解的方式去做的
 * @author xuchao
 *
 */
/*     第一种适配器
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

        //指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        System.out.println("即将跳转到jsp视图");
        return modelAndView;
    }
}*/
/*   用第二种方式配置的
public class ItemsController implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("用第二种处理器适配器====>进入Handler");
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

        //设置模型数据
        request.setAttribute("itemsList",itemsList);

        //设置转发的视图
        request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);

        //使用此方法可以通过修改response，设置响应的数据格式，比如响应json数据
        
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json串");
    }
}*/
/**
 * 
 * @author xuchao
 * @times 2016—8-16
 * 在类的上面加上@Controller注解,默认为类名首字母小写。然后url映射交给@RequestMapping类处理====>前台传了个url进来，映射器根据这个url找到Handler，
 * 然后根据Handler选择一个适配器去执行，这里全部用的都是注解，这样就将url和这个Handler连到一起了，也把url和具体的处理方法连到一起了,
 * 测试地址：http://localhost:8080/SpringMVC_Study/queryItems.action
 */
@Controller
public class ItemsController {

    // 商品查询列表    sss
    // @RequestMapping实现 对queryItems方法和url进行映射，一个方法对应一个url
    // 一般建议将url和方法写成一样
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {

    	System.out.println("基于注解的方式====>进入Handler");
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

        //指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        System.out.println("即将跳转到jsp视图");
        return modelAndView;
    }
 
}