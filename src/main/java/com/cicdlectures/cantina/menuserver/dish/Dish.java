package com.cicdlectures.cantina.menuserver.dish;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.cicdlectures.cantina.menuserver.menu.Menu;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dish {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Getter
  @EqualsAndHashCode.Include
  private Long id;

  @Getter
  @EqualsAndHashCode.Include
  private String name;

  @ManyToMany(mappedBy = "dishes")
  @Getter
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  private Set<Menu> menus;

  public Dish(String name, Set<Menu> menus) {
    this.name = name;
    this.menus = menus;
  }
}
