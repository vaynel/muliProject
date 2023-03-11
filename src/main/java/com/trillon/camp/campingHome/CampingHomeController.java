package com.trillon.camp.campingHome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campingHome")
public class CampingHomeController {

    @GetMapping("/board")
    public void campingHome(){System.out.println("board.jsp");}

    @GetMapping("/myPage")
    public void myPage(){System.out.println("myPage.jsp");}

    @GetMapping("/userPage")
    public void userPage(){System.out.println("userPage.jsp");}

    @GetMapping("/boardDetail")
    public void boardDetail(){System.out.println("boardDetail.jsp");
    }
    //@GetMapping("/board-form")
    public void createBoard(){System.out.println("createBoard");
    }
}
