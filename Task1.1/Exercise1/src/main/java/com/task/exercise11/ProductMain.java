package com.task.exercise11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] arg){
        List<Product> prdList = Arrays.asList(
                new Product("Prd1","Cat1",100),
                new Product("Prd2","Cat1",100),
                new Product("Prd3","Cat2",100),
                new Product("Prd4","Cat2",100)
        );

        Map<String, Double> avgPriceByCat = prdList.stream().collect(Collectors.groupingBy(s-> s.getCategory(),Collectors.averagingDouble(s->s.getPrice())));
        avgPriceByCat.forEach((category,avgPrice) -> System.out.println("Category : " + category + ", AVG Price:" + avgPrice));
    }
}
