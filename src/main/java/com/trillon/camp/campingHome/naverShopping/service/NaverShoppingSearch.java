package com.trillon.camp.campingHome.naverShopping.service;

import com.trillon.camp.campingHome.naverShopping.dto.Item;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class NaverShoppingSearch {
        public static String clientId = "iIeUdlh7cdCdJP_cjkx7"; //애플리케이션 클라이언트 아이디
        public static String clientSecret = "ptatbdx9pK"; //애플리케이션 클라이언트 시크릿

        public Item search(String query) throws ParseException {

        try {
            query = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + query;    // JSON 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        // string -> json으로 파싱해서 items꺼내기
        JSONParser parser = new JSONParser();
        Object Obj = parser.parse(responseBody);
        JSONObject test = (JSONObject) Obj;

            Object items = test.get("items");  // items => JSONArray타입

            JSONArray arr = (JSONArray) items;

            //for (int i=0; i<arr.size(); i++) {         // 첫번째 값만 가져올 예정이라 for문 따로 안돌림
                JSONObject tmp = (JSONObject) arr.get(0);

                String title = (String) tmp.get("title");
                String link = (String) tmp.get("link");
                String image = (String) tmp.get("image");

                String str = StringUtils.substringBetween(title,"<b>","</b>").trim();
                //log.info("split={}",str);

                Item item = new Item();
                item.setItemName(str);
                item.setLink(link);
                item.setImage(image);
            //}

        return item;
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }

}
