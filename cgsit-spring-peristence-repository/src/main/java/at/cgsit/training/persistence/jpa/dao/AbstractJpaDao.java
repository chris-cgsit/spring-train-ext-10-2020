package at.cgsit.training.persistence.jpa.dao;

import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractJpaDao< T extends Serializable> implements IAbstractJpaDao<T> {

    private Class< T > clazz;

    @Autowired
    EntityManager entityManager;

  public final void setClazz( Class< T > clazzToSet ){
    this.clazz = clazzToSet;
  }

  @Override public T findOne(long id){
    return entityManager.find( clazz, id );
  }
  @Override public List< T > findAll(){
    return entityManager.createQuery( "from " + clazz.getName() )
        .getResultList();
  }

  @Override public void create(T entity){
    entityManager.persist( entity );
  }

  @Override public T update(T entity){
    return entityManager.merge( entity );
  }

  @Override public void delete(T entity){
    entityManager.remove( entity );
  }
  @Override public void deleteById(long entityId){
    T entity = findOne( entityId );
    delete( entity );
  }

  public ChatMessage findOneSpezial(long id){
    throw new RuntimeException("not implemented");
  }

}
