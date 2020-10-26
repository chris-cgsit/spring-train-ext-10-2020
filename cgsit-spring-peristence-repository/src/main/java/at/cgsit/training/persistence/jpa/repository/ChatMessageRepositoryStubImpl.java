package at.cgsit.training.persistence.jpa.repository;

import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * if the mock test profile is enabled ensure that it is the primary repository
 */
@Repository
@Primary
@Profile("mocktest")
public class ChatMessageRepositoryStubImpl implements ChatMessageRepository {

  Logger logger = LoggerFactory.getLogger(ChatMessageRepositoryStubImpl.class);

  @Override public List<ChatMessage> findBySender(String sender) {
    logger.info("findBySender {}", sender);
    return Collections.EMPTY_LIST;
  }

  @Override public List<ChatMessage> findByXYZ(String sender) {
    logger.info("findByXYZ {}", sender);
    return Collections.EMPTY_LIST;
  }

  /**
   * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
   * entity instance completely.
   *
   * @param entity must not be {@literal null}.
   * @return the saved entity; will never be {@literal null}.
   * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
   */
  @Override public <S extends ChatMessage> S save(S entity) {
    logger.info("findByXYZ {}", entity);
    return null;
  }

  /**
   * Saves all given entities.
   *
   * @param entities must not be {@literal null} nor must it contain {@literal null}.
   * @return the saved entities; will never be {@literal null}. The returned {@literal Iterable} will have the same size
   * as the {@literal Iterable} passed as an argument.
   * @throws IllegalArgumentException in case the given {@link Iterable entities} or one of its entities is
   *                                  {@literal null}.
   */
  @Override public <S extends ChatMessage> Iterable<S> saveAll(Iterable<S> entities) {
    logger.info("saveAll");
    return null;
  }

  /**
   * Retrieves an entity by its id.
   *
   * @param aLong must not be {@literal null}.
   * @return the entity with the given id or {@literal Optional#empty()} if none found.
   * @throws IllegalArgumentException if {@literal id} is {@literal null}.
   */
  @Override public Optional<ChatMessage> findById(Long aLong) {
    logger.info("findByXYZ {}", aLong);
    return Optional.empty();
  }

  /**
   * Returns whether an entity with the given id exists.
   *
   * @param aLong must not be {@literal null}.
   * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
   * @throws IllegalArgumentException if {@literal id} is {@literal null}.
   */
  @Override public boolean existsById(Long aLong) {
    return false;
  }

  /**
   * Returns all instances of the type.
   *
   * @return all entities
   */
  @Override public Iterable<ChatMessage> findAll() {
    logger.info("findAll {}");
    return null;
  }

  /**
   * Returns all instances of the type {@code T} with the given IDs.
   * <p>
   * If some or all ids are not found, no entities are returned for these IDs.
   * <p>
   * Note that the order of elements in the result is not guaranteed.
   *
   * @param longs must not be {@literal null} nor contain any {@literal null} values.
   * @return guaranteed to be not {@literal null}. The size can be equal or less than the number of given
   * {@literal ids}.
   * @throws IllegalArgumentException in case the given {@link Iterable ids} or one of its items is {@literal null}.
   */
  @Override public Iterable<ChatMessage> findAllById(Iterable<Long> longs) {
    return null;
  }

  /**
   * Returns the number of entities available.
   *
   * @return the number of entities.
   */
  @Override public long count() {
    logger.info("count {}");
    return 0;
  }

  /**
   * Deletes the entity with the given id.
   *
   * @param aLong must not be {@literal null}.
   * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
   */
  @Override public void deleteById(Long aLong) {

  }

  /**
   * Deletes a given entity.
   *
   * @param entity must not be {@literal null}.
   * @throws IllegalArgumentException in case the given entity is {@literal null}.
   */
  @Override public void delete(ChatMessage entity) {

  }

  /**
   * Deletes the given entities.
   *
   * @param entities must not be {@literal null}. Must not contain {@literal null} elements.
   * @throws IllegalArgumentException in case the given {@literal entities} or one of its entities is {@literal null}.
   */
  @Override public void deleteAll(Iterable<? extends ChatMessage> entities) {

  }

  /**
   * Deletes all entities managed by the repository.
   */
  @Override public void deleteAll() {

  }
}
