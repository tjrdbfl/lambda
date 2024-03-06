package crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    private CrawlerServiceImpl(){
        repository= CrawlerRepository.getInstance();
    }
    public static CrawlerServiceImpl getInstance(){return instance;}
    private CrawlerRepository repository;

    @Override
    public Map<String, ?> findBugsMusic(Map<String, String> paramMap) throws IOException {
        Map<String,String> localMap=new HashMap<>();
        localMap.put("URL",paramMap.get("URL"));
        localMap.put("table","table.byChart");
        localMap.put("title","p.title");
        localMap.put("artist","p.artist");
        localMap.put("rank","strong");

        return repository.save(localMap);
    }

    @Override
    public Map<String, ?> findMelonMusic(Map<String, String> paramMap) throws IOException {
        Map<String,String> localMap=new HashMap<>();
        localMap.put("URL",paramMap.get("URL"));
        localMap.put("table","tbody");
        localMap.put("title","div.ellipsis.rank01 span");
        localMap.put("artist","div.ellipsis.rank02 span");
        localMap.put("rank","td span.rank");

        return repository.save(localMap);
    }
}

