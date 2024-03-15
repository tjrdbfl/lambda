package com.dennis.api.crawler;

import com.dennis.api.common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private final static CrawlerRepository instance = new CrawlerRepository();
    private Map<String, ?> map;
    private CrawlerRepository(){
        map=new HashMap<>();
    }
    public static CrawlerRepository getInstance(){return instance;}
    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document doc= Jsoup.connect((String) paramMap.get("URL")).timeout(10*1000).get();
        Elements elems=doc.select((String) paramMap.get("table"));
        Iterator<Element> title=elems.select((String) paramMap.get("title")).iterator();
        Iterator<Element> artist=elems.select((String) paramMap.get("artist")).iterator();
        Iterator<Element> rank=elems.select((String) paramMap.get("rank")).iterator();

        Map<String,Iterator<Element>> localMap=new HashMap<>();
        localMap.put("title",title);
        localMap.put("artist",artist);
        localMap.put("rank",rank);
        map=localMap;
        return map;
    }
}
