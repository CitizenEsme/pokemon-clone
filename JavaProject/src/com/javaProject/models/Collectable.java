package com.javaProject.models;

public class Collectable {
	
	private Position position;
	private CollectableInterface collectableObject;
	
	public Collectable(Position position, CollectableInterface collectableObject) {
		this.position = position;
		this.collectableObject = collectableObject;
	}

	public Position getPosition() {
		return this.position;
	}
	
	public CollectableInterface getCollectableObject() {
		return this.collectableObject;
	}
}
