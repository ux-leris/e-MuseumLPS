/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.service;

import com.lpsmuseum.dao.ImageDAO;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.entity.ImageDO;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Luis Eduardo
 */
public class ImageService extends MuseologicalObjectService {
    ImageDAO dao = new ImageDAO();
	
    public void createObject(Image object){
        ImageDO objDO = (ImageDO)object.getEntity();
        dao.createObject(objDO);
        
        object.setId(objDO.getId());
        object.setName(objDO.getName());
       // object.setDate(objDO.getDate().getTime());
        object.setObjectType(objDO.getObjectType());
        object.setUrlAddress(objDO.getUrlAddress());
    }

    public void editObject(Image object){
        ImageDO objDO = (ImageDO)object.getEntity();
        dao.editObject(objDO);
    }

    public Image findObject(Image object){
        ImageDO mdo = (ImageDO)findEntity(object);
        return (Image) mdo.getDto();
    }

    public ImageDO findEntity(Image object) {
        ImageDO objDO = new ImageDO();
        objDO.setId(object.getId());
        objDO.setName(object.getName());
        objDO.setDate(object.getDate().getTime());
        if(object.getObjectType() != null){
        objDO.setObjectType(object.getObjectType());}
        objDO.setUrlAddress(object.getUrlAddress());
        return (ImageDO)dao.findEntity(objDO);
    }

    public List<Image> listImages(){
        List<MuseologicalObjectDO> odos = dao.listObjects();
        List<Image> images = new ArrayList<Image>();
        for(MuseologicalObjectDO odo : odos){
            if (odo instanceof ImageDO)
                images.add((Image) odo.getDto());
        }
        return images;
    }

    public void deleteObject(Long id){
            MuseologicalObjectDO obj = new MuseologicalObjectDO();
            obj.setId(id);
            dao.deleteObject(obj);
    }

    @Override
    public Image findById(Long id){
       List<Image> images = listImages();
       
        for (Image image : images) {
            if (image.getId().equals(id))
                return image;
        }
        
        return null;
    }
    
    private Image findImageObject(Image image){
        ImageDO mdo = new ImageDO();
        mdo.setId(image.getId());
        mdo.setName(image.getName());

        mdo = (ImageDO)dao.findEntity(mdo);
        
        return mdo == null ? null : getDto(mdo);
    }

    public Image getDto(ImageDO tdo){
        Image image = new Image();
        image.setId(tdo.getId());
        image.setName(tdo.getName());
        image.setUrlAddress(tdo.getUrlAddress());
        return image;
    }
        
}
