package com.cicdlectures.menuserver.controller;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cicdlectures.menuserver.repository.DishRepository;
import com.cicdlectures.menuserver.repository.MenuRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuControllerIT {

  @LocalServerPort
  private int port;

  private URL url;

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private DishRepository dishRepository;

  @Autowired
  private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
    url = new URL("http://localhost:" + port + "/menus");
  }

  @BeforeEach
  public void initDataset() {

  }

  @AfterEach
  public void tearDown() throws Exception {
    menuRepository.deleteAll();
    dishRepository.deleteAll();
  }

  @Test
  public void listsMenus() throws Exception {

  }
}
