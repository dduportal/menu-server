package com.cicdlectures.cantina.menuserver.menu;

import com.cicdlectures.cantina.menuserver.dish.Dish;

import org.hibernate.annotations.Cascade;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Menu {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToMany
  private Set<Dish> dishes;

  public Menu(String name, Set<Dish> dishes) {
    this.name = name;
    this.dishes = dishes;
  }
}
