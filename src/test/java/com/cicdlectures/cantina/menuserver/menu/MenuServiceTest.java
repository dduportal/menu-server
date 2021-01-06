package com.cicdlectures.cantina.menuserver.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import com.cicdlectures.cantina.menuserver.dish.Dish;
import com.cicdlectures.cantina.menuserver.dish.DishRepository;

import org.junit.jupiter.api.BeforeEach;

public class MenuServiceTest {

	private MenuService sut;

	private MenuRepository menuRepository;

	private DishRepository dishRepository;

	@BeforeEach
	public void init() {
		menuRepository = mock(MenuRepository.class);
		dishRepository = mock(DishRepository.class);
		sut = new MenuService(menuRepository, dishRepository);
	}

	@Test
	@DisplayName("An empty menu (with no dishes) can be created")
	void createEmptyMenu() {
		final Menu emptyMenu = new Menu("empty", new HashSet<Dish>());
		final Menu expectedMenu = emptyMenu;

		when(menuRepository.save(emptyMenu)).thenReturn(emptyMenu);
		when(menuRepository.refresh(emptyMenu)).thenReturn(emptyMenu);

		Menu resultMenu = sut.createMenu(emptyMenu);

		verify(this.menuRepository).save(emptyMenu);
		verify(this.menuRepository).refresh(emptyMenu);

		assertEquals(expectedMenu, resultMenu);
	}

}
