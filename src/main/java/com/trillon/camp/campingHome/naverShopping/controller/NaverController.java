package com.trillon.camp.campingHome.naverShopping.controller;


import com.trillon.camp.campingHome.naverShopping.dto.Item;
import com.trillon.camp.campingHome.naverShopping.service.NaverShoppingSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class NaverController {

    private final NaverShoppingSearch shopping;

    @GetMapping("naver/shopping")
    @ResponseBody
    public void getItem(@RequestParam("query") String query) throws ParseException {
        shopping.search(query);
        //Item item = shopping.search(query);
        //log.info("item={}",item);




    }
}