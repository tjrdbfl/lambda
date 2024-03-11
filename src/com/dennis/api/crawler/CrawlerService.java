package com.dennis.api.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String,?> findBugsMusic(Map<String,String> paramMAap) throws IOException;

    Map<String,?> findMelonMusic(Map<String, String> paramMap) throws IOException;
}
