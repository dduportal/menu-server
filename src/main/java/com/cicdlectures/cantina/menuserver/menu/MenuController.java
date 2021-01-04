package com.cicdlectures.cantina.menuserver.menu;

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
  private MenuService menuService;

  @GetMapping(path = "/menus", produces = "application/json")
  public Iterable<Menu> getMenus() {
    return menuRepository.findAll();
  }

  @PostMapping("/menus")
  public Menu newMenu(@RequestBody Menu menu) {
    return menuService.createMenu(menu);
  }
}
