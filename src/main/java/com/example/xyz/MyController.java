package com.example.xyz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/my")
public class MyController {

    @GetMapping("/hellooo")
    @ResponseBody
    public String sayHello() {
        return "Hello World!$$";
    }

//    @GetMapping("/hello")
//    public String sayHello() {
//        // amit csinalni kell...
//
//        return "hello-world";
//    }

    @GetMapping(path={"/hello/{name}", "/hello"})
    public String sayHello(
            @PathVariable(name="name", required = false) String name,
            Model model
    ) {
        if (name == null) {
            model.addAttribute("name", "Anonymous");
        } else {
            model.addAttribute("product", name);
        }
        return "show-product";
    }

    @GetMapping("/hello2")
    public ModelAndView sayHello2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        modelAndView.addObject("name", "Matyi2");
        return modelAndView;
    }
}
