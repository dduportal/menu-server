package com.cicdlectures.cantina.menuserver.menu;

import java.util.HashSet;
import java.util.Set;

import com.cicdlectures.cantina.menuserver.dish.DishRepository;
import com.cicdlectures.cantina.menuserver.dish.Dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private DishRepository dishRepository;

  @GetMapping(path = "/menus", produces = "application/json")
  public Iterable<Menu> getMenus() {
    return menuRepository.findAll();
  }

  @PostMapping("/menus")
  Menu newMenu(@RequestBody Menu menu) {
    Set<Dish> dishes = new HashSet<Dish>();

    for(Dish dish: menu.getDishes()) {
      Dish got = dishRepository.findByName(dish.getName());

      if (got == null) {
        got = dishRepository.save(dish);
      }

      dishes.add(got);
    }

    menu.setDishes(dishes);

    return menuRepository.save(menu);
  }
}
