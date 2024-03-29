package com.dennis.api.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    private final static CrawlerServiceImpl service=CrawlerServiceImpl.getInstance();
    public Map<String,?> findBugsMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하세요.");
        String url=sc.next();
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("URL","https://music.bugs.co.kr/chart");
        return service.findBugsMusic(paramMap);
    }

    public Map<String,?> findMelonMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하세요.");
        String url=sc.next();
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("URL","https://www.melon.com/chart/index.htm");
        return service.findMelonMusic(paramMap);
    }
}
