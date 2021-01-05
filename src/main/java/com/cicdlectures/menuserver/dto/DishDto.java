package com.cicdlectures.menuserver.dto;

import java.util.Set;
import java.util.HashSet;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

import com.cicdlectures.menuserver.model.Dish;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Setter
@Accessors(chain = true)
public class DishDto {

  private Long id;

  private String name;

  public static Set<DishDto> fromModelSet(Set<Dish> models) {
    Set<DishDto> dishes = new HashSet<>();

    for (Dish model : models) {
      dishes.add(DishDto.fromModel(model));
    }

    return dishes;
  }

  public static DishDto fromModel(Dish dish) {
    return new DishDto().setId(dish.getId()).setName(dish.getName());
  }
}
