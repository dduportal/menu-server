package com.cicdlectures.cantina.menuserver.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

  @Autowired
  private DishRepository dishRepository;

  @GetMapping(path = "/dishes", produces = "application/json")
  public Iterable<Dish> getDishes() {
    return dishRepository.findAll();
  }

  @PostMapping("/dishes")
  public Dish newDish(@RequestBody Dish dish) {
    return dishRepository.save(dish);
  }
}
