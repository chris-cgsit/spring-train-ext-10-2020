package at.cgsit.training.persistence.jpa.dao;

import at.cgsit.training.persistence.jpa.model.ChatMessage;

import java.io.Serializable;
import java.util.List;

/**
 * implements old style base abstract DAO and interface
 * @param <T>
 */
public interface IAbstractJpaDao<T extends Serializable> {
  T findOne(long id);

  List<T> findAll();

  void create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(long entityId);

  ChatMessage findOneSpezial(long id);

}
