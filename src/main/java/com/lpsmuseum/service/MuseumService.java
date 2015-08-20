package com.lpsmuseum.service;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dao.MuseumDAO;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.MuseumDO;
import com.lpsmuseum.entity.ScenarioDO;

public class MuseumService {
	MuseumDAO dao = new MuseumDAO();
	
	public void createMuseum(Museum museum) throws Exception{
		MuseumDO mdo = getEntity(museum);
		dao.createMuseum(mdo);
		museum.setId(mdo.getId());
	}
	
	public void editMuseum(Museum museum) throws Exception{
		MuseumDO mdo = getEntity(museum);
		dao.editMuseum(mdo);
	}
	
	private MuseumDO getEntity(Museum museum) throws Exception{
		ScenarioService svc = new ScenarioService();
		MuseumDO museumDO = new MuseumDO();
		ArrayList<ScenarioDO> scenarios = new ArrayList<ScenarioDO>();
		museumDO.setId(museum.getId());
		museumDO.setName(museum.getName());
		for(Scenario s : museum.getScenarios()){
			ScenarioDO scenarioDO = svc.findEntity(s);
			if(scenarioDO == null) throw new Exception("Could not find scenario " + s.getName() + "!");
			else if(scenarioDO.getMuseum() != null
					&& scenarioDO.getMuseum().getId() != museum.getId()) throw new Exception("One of the scenarios belongs to another museum!");
			scenarioDO.setMuseum(museumDO);
			scenarios.add(scenarioDO);
		}
		museumDO.setScenarios(scenarios);
		return museumDO;
	}
	
	private Museum getDto(MuseumDO museumDO){
		ArrayList<Scenario> scos = new ArrayList<Scenario>();
		for(ScenarioDO s : museumDO.getScenarios()){
			scos.add(s.getDto());
		}
		Museum museum = new Museum(museumDO.getName(), scos);
		museum.setId(museumDO.getId());
		return museum;
	}
	
	public Museum findById(Long id){
		Museum m = new Museum();
		m.setId(id);
		return findMuseum(m);
	}
	
	public Museum findByName(String name){
		Museum m = new Museum();
		m.setName(name);
		return findMuseum(m);
	}
	
	private Museum findMuseum(Museum museum){
		MuseumDO mdo = new MuseumDO();
		mdo.setId(museum.getId());
		mdo.setName(museum.getName());
		mdo = (MuseumDO)dao.findEntity(mdo);
		return mdo == null ? null : getDto(mdo);
	}
	
	public ArrayList<Museum> listMuseum(){
		List<MuseumDO> mdos = dao.listMuseums();
		ArrayList<Museum> mus = new ArrayList<Museum>();
		for(MuseumDO mdo : mdos){
			mus.add(getDto(mdo));
		}
		return mus;
	}
	
	public void deleteMuseum(Long id){
		MuseumDO mdo = new MuseumDO();
		mdo.setId(id);
		dao.deleteMuseum(mdo);
		
	}

	public List<Scenario> listScenariosByMuseumId(Long id) {
		for (Museum m : listMuseum())
			if (m.getId().equals(id))
				return m.getScenarios();
		return null;
	}
}
