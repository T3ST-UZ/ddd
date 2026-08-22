package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuData {

    private String menuName;
    private int expectedSize;
    private String[] expectedItems;
}
