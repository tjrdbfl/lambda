package crawler;

import lombok.SneakyThrows;
import org.jsoup.nodes.Element;
import user.UserController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    @SneakyThrows
    public static void main(Scanner sc) {
        CrawlerController crawlerController = new CrawlerController();
        Map<String,?> map;
        Iterator<Element> title,artist,rank;

        while(true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-벅스뮤직\n " +
                    "2-멜론\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("0-종료");return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    Map<String,?> bugsMap=crawlerController.findBugsMusic(sc);

                    System.out.println("벅스 뮤직 결과 : ");

                    title= (Iterator<Element>) bugsMap.get("title");
                    artist= (Iterator<Element>) bugsMap.get("artist");
                    rank= (Iterator<Element>) bugsMap.get("rank");
                    while (rank.hasNext()){
                        System.out.println(rank.next().text()+"위 "+artist.next().text()
                                +"-"+title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("2-멜론");
                    map=crawlerController.findMelonMusic(sc);

                    title= (Iterator<Element>) map.get("title");
                    artist= (Iterator<Element>) map.get("artist");
                    rank= (Iterator<Element>) map.get("rank");
                    while (rank.hasNext()){
                        System.out.println(rank.next().text()+"위 "+artist.next().text()
                                +"-"+title.next().text());
                    }
                    break;
                case "3":
                    System.out.println("3-ID 검색");

                    break;
                case "4":
                    System.out.println("4-비번변경");

                    break;
                case "5":
                    System.out.println("5-탈퇴");

                    break;
                case "6":
                    System.out.println("6-회원목록");

                    break;
                case "7":
                    System.out.println("7-이름검색");

                    break;
                case "8":
                    System.out.println("8-직업검색");

                    break;
                case "9":
                    System.out.println("9-회원수");

                    break;
            }
        }

    }
}
