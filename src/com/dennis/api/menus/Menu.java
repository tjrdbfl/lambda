package com.dennis.api.menus;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Menu {
    private long id;
    private String category;
    private String item;

    @Builder(builderMethodName = "builder")
    public Menu(long id, String category,String item) {
        this.id = id;
        this.category = category;
        this.item = item;
    }
}
