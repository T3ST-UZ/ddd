package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductData {

    private String name;
    private String url;
    private String price;
}
