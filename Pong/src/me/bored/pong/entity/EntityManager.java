package me.bored.pong.entity;

import java.util.ArrayList;
import java.util.HashSet;

public class EntityManager {
	
	public EntityManager(){
	}
	
	private HashSet<Integer> ids = new HashSet<Integer>();
	
	ArrayList<Entity> entities = new ArrayList<Entity>();
	ArrayList<Entity> entitiesrem = new ArrayList<Entity>();
	
	public int assignId(Entity entity) {
		int i = ids.size() + 1;
		ids.add(i);
		entities.add(entity);
		return i;
	}
	
	public void remove(Entity entity){
		ids.remove(entity.getId());
		entitiesrem.add(entity);
		for(Entity ent : entitiesrem){
			ids.remove(ent.getId());
			entities.remove(ent);
		}
		entitiesrem.clear();
	}
	
	public void removeAll(){		
		for(Entity ent : entities){
			ids.remove(ent.getId());
			entitiesrem.add(ent);
		}
		for(Entity ent : entitiesrem){
			entities.remove(ent);
		}
		entitiesrem.clear();
	}
}