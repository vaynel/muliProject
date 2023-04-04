package com.trillon.camp.campingHome.naverShopping.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.trillon.camp.campingHome.naverShopping.dto.Item;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
@Slf4j
public class NaverShoppingSearch {
        public static String clientId = "iIeUdlh7cdCdJP_cjkx7"; //애플리케이션 클라이언트 아이디
        public static String clientSecret = "ptatbdx9pK"; //애플리케이션 클라이언트 시크릿

        public Item search(String query) throws ParseException, IOException {

//        try {
//            query = URLEncoder.encode(query, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException("검색어 인코딩 실패",e);
//        }  질문사항!!!!!!!!!!!

        String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + query;


            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(StandardCharsets.UTF_8));


            RequestEntity<Void> req = RequestEntity
                    .get(apiURL)
                    .header("X-Naver-Client-Id",clientId)
                    .header("X-Naver-Client-Secret",clientSecret)
                    .build();

            ResponseEntity<String> result = restTemplate.exchange(req, String.class);
            String res = result.getBody(); // JSON 형태 String


            ObjectMapper mapper = new ObjectMapper();

            Map<String,Object> map = mapper.readValue(res, Map.class);
            ArrayList items = (ArrayList) map.get("items");

            Map<String, String> itemInfo = (Map<String, String>) items.get(0);

            String title = itemInfo.get("title");
            String itemName = StringUtils.substringBetween(title,"<b>","</b>").trim();

            Item item = new Item();
            item.setItemName(itemName);
            item.setLink(itemInfo.get("link"));
            item.setImage(itemInfo.get("image"));

        return item;
    }

}
