package com.lpsmuseum.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.entity.MuseologicalObjectDO;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioDO;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.ThemeService;

public class Scenario {
	private Long id;
	private String name;
	private String dtype;
	private List<MuseologicalObject> objects;
	private Calendar date;
	private Long idMuseum;
	private Theme theme;
	
	public Scenario(){
		
	}
	
	public Scenario(String name){
		this(name, new ArrayList<MuseologicalObject>());
	}
	
	public Scenario(String name, List<MuseologicalObject> objects){
		this.name = name;
		this.objects = objects;
		getHistoricalTime();
	}

	public Calendar getHistoricalTime() {
		sortScenario();
		return date;
	}

	private void sortScenario() {
		if(objects.size() > 0){
			Collections.sort(objects, new Comparator<MuseologicalObject>() {
		        public int compare(MuseologicalObject  obj1, MuseologicalObject  obj2)
		        {
		            return  obj1.getDate().compareTo(obj2.getDate());
		        }
		    });
			date = objects.get(0).getDate();
		}		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDtype() {
		return dtype;
	}
	
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public List<MuseologicalObject> getObjects(){
		return objects;
	}
	
	/*public ScenarioDO getEntity() throws Exception{
		ScenarioDO scenarioDO = new ScenarioDO();
		scenarioDO.setName(getName());
		scenarioDO.setId(getId());
		if(idMuseum != null){
			MuseumDO mdo = new MuseumDO();
			mdo.setId(idMuseum);
			scenarioDO.setMuseum(mdo);
		}
		MuseologicalObjectService svc = new MuseologicalObjectService();
		for(MuseologicalObject obj : getObjects())
		{
			MuseologicalObjectDO objDO = svc.findEntity(obj);
			if(objDO != null) scenarioDO.getObjects().add(objDO);
			else throw new Exception("Could not find object " + obj.getName() + "!");
		}
		scenarioDO.setTheme(new ThemeService().getEntity(theme));
		return scenarioDO;
	}*/

	public Long getIdMuseum() {
		return idMuseum;
	}

	public void setIdMuseum(Long idMuseum) {
		this.idMuseum = idMuseum;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
