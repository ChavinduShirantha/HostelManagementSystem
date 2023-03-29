package lk.ijse.hibernate.d24.dao;

import lk.ijse.hibernate.d24.entity.SuperEntity;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:53 AM
 **/
public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO{
    boolean save(T entity);
}
