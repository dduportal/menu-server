package com.cicdlectures.cantina.menuserver.menu;

import com.cicdlectures.cantina.menuserver.dish.Dish;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Menu {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Getter
  @EqualsAndHashCode.Include
  private Long id;

  @Getter
  @EqualsAndHashCode.Include
  private String name;

  @ManyToMany(cascade = CascadeType.REFRESH)
  @Getter
  @Setter
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Set<Dish> dishes;

  public Menu(String name, Set<Dish> dishes) {
    this.name = name;
    this.dishes = dishes;
  }
}
