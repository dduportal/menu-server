package com.cicdlectures.cantina.menuserver.dish;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.cicdlectures.cantina.menuserver.menu.Menu;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dish {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;

  @ManyToMany(mappedBy = "dishes")
  private Set<Menu> menus;

  public Dish(String name, Set<Menu> menus) {
    this.name = name;
    this.menus = menus;
  }
}
