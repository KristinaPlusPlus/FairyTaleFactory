package edu.ramapo.KristinaCorrado.fairytalefactory;

import java.io.Serializable;

public class Hero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//Constructor of the hero
	public Hero(){
		//Initialize EVERYTHING!!
		name = null;
		isMale = true;
		isEnthralled = false;
		isAlive = true;
		isInjured = false;
		injuryType = null;
		markType = null; 
		isUgly = false; 
		isDisguised = false; 
		disguiseType = null; 
		isRoyal = false; 
		mood = null; 
		hasMagic = false; 
		magicType = null; 
		hasWeapon = false; 
		weaponType = null; 
	}
	
	//All the private objects of the hero
	public String name; //Name of the hero
	public boolean isMale; //Gender of the hero
	public boolean isEnthralled; //The relationship status
	public boolean isAlive; //Indicate if character has died
	public boolean isInjured; //Did the hero get injured
	public String injuryType; //What type of injury ifInjured
	public String markType; //If injuryType is scar
	public boolean isUgly; //appearanceType
	public boolean isDisguised; //If hero has a disguise
	public String disguiseType; //Type of disguise if isDisguised
	public boolean isRoyal; //The social standing of the character
	public String mood; //Effects course of action to different events
	public boolean hasMagic; //If hero possesses magic
	public String magicType; //What type of magic the hero possesses
	public boolean hasWeapon; //What hero uses as weapon, non-magic
	public String weaponType; //Type of weapons
}
