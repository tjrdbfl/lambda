package com.dennis.api.board;

import com.dennis.api.common.UtilService;
import com.dennis.api.common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoardView {
    public static void main() {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();

        for(int i =0;i<5;i++){
            articles.add(Board.builder()
                    .boardName(util.createRandomTitle())
                    .boardType(util.createRandomContent())
                    .build());
        }

        for(Board i : articles){
            System.out.println(i.toString());
        }

        articles.forEach(i -> {
            System.out.println(i.toString());
        });
    }

}
