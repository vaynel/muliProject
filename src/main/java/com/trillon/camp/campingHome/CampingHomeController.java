package com.trillon.camp.campingHome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campingHome")
public class CampingHomeController {

    @GetMapping("/myPage")
    public void myPage(){System.out.println("myPage.jsp");}

    @GetMapping("/userPage")
    public void userPage(){System.out.println("userPage.jsp");}

}
