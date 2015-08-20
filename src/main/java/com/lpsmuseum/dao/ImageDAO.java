/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.dao;

import com.lpsmuseum.entity.ImageDO;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Luis Eduardo
 */
public class ImageDAO extends MuseologicalObjectDAO {
    
    public void createObject(ImageDO object){
        create(object);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Object findEntity(Object obj) {
        ImageDO odo = (ImageDO) obj;
        EntityManager em = PersistenceUtil.getEntityManager();
        if(odo.getId() != null){
            Object xdo = em.find(ImageDO.class, odo.getId());
            return xdo;
        } else{
            List<ImageDO> odos = (List<ImageDO>)em.createQuery("SELECT o FROM MuseologicalObjectDO o WHERE o.name = '" + odo.getName()  + "'")
                    .getResultList();
            odo = odos.isEmpty() ? null : odos.get(0);
        }
        em.close();
        return odo;
    }
    
    public void editObject(ImageDO objDO) {
        merge(objDO);		
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MuseologicalObjectDO> listObjects(){
        return list("ImageDO");
    }

    public void deleteObject(ImageDO object){
        delete(object);
    }
        
}
