package com.trillon.camp.campingHome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CampingHomeController {

    @GetMapping("/board/campingHome")
    public void campingHome(){System.out.println("campingHome.jsp");}

    @GetMapping("/myPage")
    public void myPage(){System.out.println("myPage.jsp");}

    @GetMapping("/userPage")
    public void userPage(){System.out.println("userPage.jsp");}


}
