package com.cicdlectures.cantina.menuserver.menu;

import com.cicdlectures.cantina.menuserver.dish.DishRepository;
import com.cicdlectures.cantina.menuserver.dish.Dish;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private DishRepository dishRepository;

  public MenuService(MenuRepository menuRepository, DishRepository dishRepository) {
    this.dishRepository = dishRepository;
    this.menuRepository = menuRepository;
  }

  public Menu createMenu(Menu menu) {
    Set<Dish> dishes = new HashSet<Dish>();

    for (Dish dish : menu.getDishes()) {
      Dish got = dishRepository.findByName(dish.getName());

      if (got == null) {
        got = dishRepository.save(dish);
      }

      dishes.add(got);
    }

    menu.setDishes(dishes);

    menuRepository.save(menu);

    return menuRepository.refresh(menu);
  }
}
