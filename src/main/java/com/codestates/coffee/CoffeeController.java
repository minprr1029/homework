package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> coffee1 = new HashMap<>();
        long coffeeId = 1L;
        coffee1.put("coffeeId", coffeeId);
        coffee1.put("korName", "바닐라 라떼");
        coffee1.put("engName", "Vanilla Latte");
        coffee1.put("price", 4500);

        coffees.put(coffeeId, coffee1);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    @PutMapping("/{coffee-id}")
    public ResponseEntity getcoffee(@PathVariable("coffee-id") long coffeeId) {
        coffees.get(1L).put("korName", "바닐라 빈 라떼");
        coffees.get(1L).put("price", 5000);
        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }
    @DeleteMapping("/{coffee-id}")
    public ResponseEntity delcoffee() {
        coffees.remove(1L);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}