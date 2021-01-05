package com.cicdlectures.menuserver.service;

import static org.mockito.Mockito.mock;

import com.cicdlectures.menuserver.repository.MenuRepository;
import com.cicdlectures.menuserver.repository.DishRepository;

import org.junit.jupiter.api.BeforeEach;

public class CreateMenuServiceTests {

	private CreateMenuService sut;

	private MenuRepository menuRepository;

	private DishRepository dishRepository;

	@BeforeEach
	public void init() {
		menuRepository = mock(MenuRepository.class);
		dishRepository = mock(DishRepository.class);
		sut = new CreateMenuService(menuRepository, dishRepository);
	}
}
