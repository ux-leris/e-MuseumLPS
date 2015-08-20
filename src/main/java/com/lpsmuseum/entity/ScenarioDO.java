package com.lpsmuseum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.ThemeService;

@Entity
@Table(name="scenario")
@Inheritance
@SuppressWarnings("serial")
public class ScenarioDO implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_scenario")
	private Long id;
	@NotNull
	@Column(name="name")
	private String name;	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="scenario_object", joinColumns={@JoinColumn(name="id_scenario")}, inverseJoinColumns={@JoinColumn(name="id_object")})
	private List<MuseologicalObjectDO> objects;
	@ManyToOne
	@JoinColumn(name = "id_museum")
	private MuseumDO museum;
	@ManyToOne
	@JoinColumn(name = "id_theme")
	private ThemeDO theme;
	
	public ScenarioDO(){
		objects = new ArrayList<MuseologicalObjectDO>();
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String description) { this.name = description; }
	public List<MuseologicalObjectDO> getObjects() { return objects; }
	public void setObjects(List<MuseologicalObjectDO> objects) { this.objects = objects; }
	public MuseumDO getMuseum() { return museum; }
	public void setMuseum(MuseumDO museum) { this.museum = museum; }
	public ThemeDO getTheme() { return theme; }
	public void setTheme(ThemeDO theme) { this.theme = theme; }

	public Scenario getDto() {
		Scenario s = new Scenario(getName());
		s.setId(getId());
		for(MuseologicalObjectDO obj : getObjects()){
			s.getObjects().add(obj.getDto());
		}
		if(museum != null) s.setIdMuseum(museum.getId());
		s.setTheme(new ThemeService().getDto(theme));
		return s;
	}
}
