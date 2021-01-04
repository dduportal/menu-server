package com.cicdlectures.cantina.menuserver.storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface RefreshRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
  T refresh(T t);
}
