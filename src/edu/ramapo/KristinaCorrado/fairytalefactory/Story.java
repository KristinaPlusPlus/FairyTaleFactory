package edu.ramapo.KristinaCorrado.fairytalefactory;

import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

public class Story implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//The Story class constructor
	public Story(){
		//Initialize EVERYTHING!!
		heroChar = new Hero(); //The hero of the story
		branchSet = 'B'; 
		isBranchOver = false; 
		isConflict = true;
		storyMode = -1;
		
		//About the villain
		isVillainPresent = false; 
		isVillainMale = true;
		isVillainDead = false;
		villianName = null; 
		

		//symbolic object type
		objectName = null;	
		objectType = null;
		isObjUnbreakable = false;
		isobjectBroken = true;	

		//other supporting characters (SMORG)
		isSmorgAlive = true;
		isSmorgInjured = false;
		isSmorgFriendly = true;
	}
	
	//Tells the story of the fairy tale
	public String storyTeller(){
		
		//Create string to hold the whole story
		String plot= "";
		
		//Get hero/villain pronouns
		String heroTitle;
		String heroPosses;
		String heroPro;
		String villainTitle;
		String villainPosses;
		String villainPro;
		if(heroChar.isMale){
			heroTitle = "prince";
			heroPosses = "his";
			heroPro = "he";
		}
		else{
			heroTitle = "princess";
			heroPosses = "her";
			heroPro = "she";
		}
		if(isVillainMale){
			villainTitle = "king";
			villainPosses = "his";
			villainPro = "he";
		}
		else{
			villainTitle = "queen";
			villainPosses = "her";
			villainPro = "she";
		}
		
		//Get the beginning of the story
		if(branchSet == 'B'){
			//Get the random number
			plot += "Once upon a time in a land far away, ";
			Random generator = new Random();
			storyMode = generator.nextInt(2);
			switch(storyMode){
			//ABSENTATION plot line
			case 0:
				plot += "in the kingdom known as Abilene, the royal family Gestalt ruled the land." +
						"  They didn’t particularly like ruling the land because it required a lot of work, though." +
						"  Although one would ASSUME that they were resigned to this fate, since they had been ruling the land" +
						" for multiple generations, this all changed the day that Old Man Gestalt (the High King) decided to" +
						" up and abdicate the throne without a word to his family." +
						"  This left "+ heroChar.name +", a young "+ heroTitle +" of only 16 years in age, to rule the kingdom." +
						"  Unfortunately, like "+ heroPosses +" parents, "+ heroChar.name +" had no urge to rule the land.\n\n";
				plot += "  This was all good and swell for "+ villianName +", the Royal Overseer of the Kingdom, second only to the" +
						" King in power. Unbeknownst to the noble people of Abilene, "+ villianName +" had actually tempted the High" +
						" King into leaving with several well placed adds to foreign, glamorous vacation spots in other kingdoms at" +
						" discounted rates. "+ villianName +"’s next plan: fill the abdicated throne once the "+ heroTitle+" is proven" +
						" to be incompetent to the public.";
				isBranchOver = true;
				nextOption = 1;
				break;
			//INTERDICTION plot line
			case 1:
				plot += "there was a young "+ heroTitle +" by the name of "+ heroChar.name +" that enjoyed eating pie." +
						" Unfortunately, this lead to high blood sugar and cholesterol at a young age." +
						" Sensing the impending doom to the young "+ heroTitle +", the king and queen banished sweets from" +
						" the land. The "+ heroTitle +" was told that "+ heroPro +" could never partake in sweets ever again," +
						" lest "+ heroPro +" lose "+ heroPosses +" good looks and physique.\n\n";
				plot += "  But blood sugar and general good health were the least of the "+ heroTitle +"’s concern. "+ villianName +
						", a nefarious character, longed to usurp the throne, ever since being appointed the Royal Overseer. "+
						villainPro +" knew that the only way to become "+ villainTitle +" of the land was to somehow make the " +
						heroTitle +" fall victim to his desires to eat sweet treats. The delectable treats would be young " +
						heroChar.name +"’s downfall. With a cackle, "+ villianName +" began to plot. ";
				isBranchOver = true;
				//Get next logical progression in the story
				nextOption = generator.nextInt(2)+1;
				break;
			/*//DELIVERY plot line
			case 2:
				plot += "the evil "+ villianName +", dark wizard of the realm, was in the process of collecting the 7 most" +
						" magical items in the land. The intention: to use them to control the people’s hearts and minds,"+
						" turning them into "+ villainPosses +" puppets and do other such evil things as well." +
						" Like leave all of the kingdom’s faucets running at night, so that their water bills would be" +
						" excessively high. Or hogging all of the medieval wi-fi. Yes. Pure evil.\n\n";
				plot += "  But when Evil looms across the land, Good must also rise to fight it. The Royal Family’s Order of" +
						" Knights, lead by "+ heroTitle +" "+ heroChar.name +", who heard of the evil Wizard’s plan, chose to" +
						" dispatch the Knights to find and reclaim the items. Specifically, the "+ objectName +", which will " +
						objectAction + ".";
				isBranchOver = true;
				break;*/
			}
		}
		//Get middle story line
		else if(branchSet =='M'){
			switch(storyMode){
			//ABSENTATION plot line
			case 0:
				plot +=tellAbsentationplot();
				break;
			//INTERDICTION plot line
			case 1:
				plot+=tellInterdictionplot();
				break;
			//DELIVERY plot line
			case 2:
				break;
			}
		}
		
		//If branch is over then make branch change
		if(isBranchOver){
			//Change from beginning to middle
			if(branchSet == 'B'){
				branchSet = 'M';
				isBranchOver = false;
			}
			//Change from middle to end
			else if(branchSet == 'M'){
				branchSet = 'E';
				isBranchOver = true;
			}
		}
		
		//Return the story line
		return plot;
	}
	
	//ABSENTATION plot line for the middle
	public String tellAbsentationplot(){
		String plot="";
		int rand;
		
		//Get hero/villain pronouns
		String heroTitle;
		String heroPosses;
		String heroPro;
		String villainTitle;
		String villainPosses;
		String villainPro;
		if(heroChar.isMale){
			heroTitle = "prince";
			heroPosses = "his";
			heroPro = "he";
		}
		else{
			heroTitle = "princess";
			heroPosses = "her";
			heroPro = "she";
		}
		if(isVillainMale){
			villainTitle = "king";
			villainPosses = "his";
			villainPro = "he";
		}
		else{
			villainTitle = "queen";
			villainPosses = "her";
			villainPro = "she";
		}
		
		//Check which path was chosen
		Random generator = new Random();
		switch(nextOption){
		//Reconnaissance Case
		case 1:
			plot += "  Where the difficulty lies for "+ villianName +" is simply how.   " + heroChar.name + ", however young," +
					" is loved by the Abeline people.  What makes a " + heroTitle + " weak?  What makes the" + heroTitle + " incompetent?  "+
					villianName +" spent day after day pondering in the royal study, seeking out any way to discredit the " + heroTitle + ".  "+
					villianName +" looked out into the castle courtyard: “There must be something… and I think I know just how.";
			//Get next logical progression in the story
			nextOption = 2;
			break;
		//Trickery Case
		case 2:
			plot += villianName + " calls  " + heroChar.name + " into the castle gardens.  “" + heroChar.name + ", there are important matters of" +
					" the crown that we must discuss”.    " + heroChar.name + " walks in, confused and apathetic.  To " + heroPro + ", nothing about being " +
					heroTitle + " is important.  At just 16 years old, the only important thing to “ + heroPro + “ is their Call of Duty K/D Ratio.  But "+
					villianName +" remains persistent.  “It is a matter of life or death.  For the future of the kingdom.”  "+ villianName +" looked out over" +
					" the fields, just past the castle.  “The farmers on our land, our own people, wish to overthrow you.”   " + heroChar.name + " looks up, " +
					"feeling concerned.";
			//Get next logical progression in the story
			nextOption = 3;
			break;
		//Complicity Case
		case 3:
			plot += "“You must deal with this”.  "+ villianName +" scolds  " + heroChar.name + ".   " + heroChar.name + " nods in agreement “…but what do I do? How" +
					" do I deal with it?”  “Simple… you have them arrested. Rule by fear.  That will teach them not to be unfaithful to the " + heroTitle + ".”   " +
					heroChar.name + " looks down, doubtful… but ultimately decides to trust "+ villianName +", as " + heroPosses + " father has.   " + heroChar.name +
					" calls the commander of the guards.  “Arrest anybody who is suspected of committing treason.”   “Anybody.”  "+ villianName +" Repeats.";
			//Get next logical progression in the story
			nextOption = 4;
			break;
		//Villain or Lack Case
		case 4:
			plot+="The royal guards patrolled the nearby towns, arresting countless innocent people on charges of treason in the name of the crown.  These villagers and" +
					" farmers were placed in the castle dungeon, away from their lives and families . The " + heroTitle + " is viewed as a tyrant, and has begun to be hated by "
					+ heroPosses + " own people.";
			//Get next logical progression in the story
			nextOption = 5;
			break;
		//Mediation Case
		case 5:
			plot += "Over the following months, the kingdom grew quite poor.  The farmers were all imprisoned, the merchants were all in hiding, and the Computer Scientists and" +
					" IT Professionals were driven from the land.  The Royal WiFi was running a download rate of 10 kilobytes per second.  Smorg, the Royal council, burst into the " +
					heroTitle + "’s chamber.  “You have to stop this,  " + heroChar.name + "!”.   " + heroChar.name + " jumped back in surprise.  “What do you mean?  The arrests?”  “YES.”" +
					"  Smorg yelled back at him.  “Those are all innocent people. With all of them gone, our economy doesn’t exist!”   " + heroChar.name + " shook " + heroPosses + " head.  “"
					+ villianName +" told me that all of those people wanted to overthrow me. That they were criminals.”  “And you believed him?  " + heroChar.name + ", he lied to you. He is" +
					" the reason your father is gone.  He is the one who wants to overthrow you.”";  
			//Get next logical progression in the story
			nextOption = 6;
			break;
		//Beginning Counteraction Case
		case 6:
			rand = generator.nextInt(2);
			if(rand == 0){
				plot += heroChar.name + " races to the guards’ barracks to tell them to arrest "+ villianName +", and the royal guard rises in support.  As a group, they race into "+ villianName +
						"’s quarters, and arrest him.  He is brought to the dungeon, with the villagers that he had arrested.";
				//Get next logical progression in the story
				nextOption = 7;
			}
			else{
				plot += heroChar.name + " races to the guards’ barracks to tell them to arrest "+ villianName +", but " + villianName + " was already waiting, with the guards under " + villainPosses +
						" command.  The guards draw their swords, arrest  " + heroChar.name + ", and place" + heroPro + " in the dungeon with the villagers that the  " + heroTitle + " had originally arrested.  "
						+ villianName +" has officially become the ruler of Abilene.";
				isBranchOver = true;
			}
			break;
		//Difficult task Case
		case 7:
			plot += "After the arrest of  "+ villianName +", Smorg enters the royal court, and speaks softly to  " + heroChar.name + ".  “The guilt of treason is already with " + villainPro + ".  It is your choice " +
					"what you wish to be done.”    " + heroChar.name + " looks down to ponder.  “I think I know what has to be done.";
			rand = generator.nextInt(3);
			if(rand == 0){
				//Get next logical progression in the story
				nextOption = 8;
			}
			else if(rand == 1){
				//Get next logical progression in the story
				nextOption = 9;
			}
			else{
				//Get next logical progression in the story
				nextOption = 10;
			}
			break;
		//Victory case
		case 8:
			plot += villianName +" is exiled from the kingdom, and the villagers are freed from the prison.  Through these hard experiences, " +
					heroTitle + "  " + heroChar.name + " has learned to be a great king…  and loves it.  Everybody lives happily ever after.";
			isBranchOver = true;
			break;
		//Exposure case
		case 9:
			plot += villianName + " is taken out of the royal court, and moved out of the castle.  All of the villagers are freed, and through" +
					" word of mouth, for generations to come, everybody knows of the evil that "+ villianName +" has performed.  Through these hard" +
					" experiences, " + heroTitle + "  " + heroChar.name + " has learned to be a great king…  and loves it."; 
			isBranchOver = true;
			break;
		//Punishment case
		case 10:
			plot += heroChar.name + " decides to leave "+ villianName +" in prison… this way, " + villainPosses + " horrid ways could never affect anybody," +
					" ever again.  Through these hard experiences, " + heroTitle + "   has learned to be a great king…  and loves it.";  
			isBranchOver = true;
			break;
		}
		
		
		return plot;
	}
	
	//INTERDICTION plot line
	public String tellInterdictionplot(){
		
		String plot="";
		int rand;
		
		//Get hero/villain pronouns
		String heroTitle;
		String heroPosses;
		String heroPro;
		String villainTitle;
		String villainPosses;
		String villainPro;
		if(heroChar.isMale){
			heroTitle = "prince";
			heroPosses = "his";
			heroPro = "he";
		}
		else{
			heroTitle = "princess";
			heroPosses = "her";
			heroPro = "she";
		}
		if(isVillainMale){
			villainTitle = "king";
			villainPosses = "his";
			villainPro = "he";
		}
		else{
			villainTitle = "queen";
			villainPosses = "her";
			villainPro = "she";
		}
		
		//Check which path was chosen
		Random generator = new Random();
		switch(nextOption){
		//Reconnaissance Case
		case 1:
			plot+= "Knowing that mounting a silent rebellion would be hard against the "+ heroTitle + ", "
					+ villianName + " slowly took their time to creep amongst the royal records in the castle" +
					" and retrieve information about the "+ heroTitle + "’s favorite treats.  As it would appear," +
					" the little porker enjoyed chocolate most of all, and as fate would have it, that was exactly" +
					" what the vile "+ villianName +" was in possession of.  "+ villianName +" also found out that our" +
					" hero was a big fan of hot dog eating competitions and competitive juggling.  "+ villainPro +
					" didn’t exactly know what to do with this information, but "+ villainPro +" did know one thing: "+
					villainPro+" had to plan.";
			//Get next logical progression in the story
			nextOption = 2;
			break;
		//Violation Of Case
		case 2:
			plot+="Knowing that the " +heroTitle+" was in withdrawal from "+heroPosses+" sweets, "+villianName+
				" carefully laid out "+villainPosses+" trap.  Under "+heroPosses+" pillow, in "+heroPosses+" royal shower," +
				" in "+heroPosses+" royal toilet, and in "+heroPosses+" favorite stuffed animal, "+villianName+" planted the " +
				"best, fattest sweets in the land.  Twizzler-Ties in the pillow, Sugar Coated Cake Batter Popsicle Sticks in the" +
				" stuffed animal, and Royal Fudge Dumplings in the bathroom.";

			//Get next logical progression in the story
			rand = generator.nextInt(2);
			if(rand == 0){
				plot+="Our "+heroTitle+", try as "+heroPro+" might, could not resist.  First went in the Twizzler-Ties, then the Popsicle" +
						" Sticks, and finally, the precious Royal Fudge Dumplings.  No sweet was spared, and the "+heroTitle+", shortly " +
						"after, plunged into a sugar coma, never to awaken again.";
				isBranchOver = true;
			}
			else{
				plot+= "Upon returning to " +heroPosses+ " domicile for the afternoon after a nice game of royal shuffle board (it’s like " +
						"normal shuffle board, only instead of those little disc things, they use large plates of gold that in no way is a" +
						" sign of them ignoring the plight of the poor in their kingdom), the "+heroTitle+" was aghast to find the sweets in "
						+heroPosses+" room.";
				nextOption=3;
			}
			break;
		//Departure Case
		case 3:
			plot+= heroPro +" had no choice.  Unable to handle the constant confrontation with sweets, the "+ heroTitle +" fled the castle and" +
					" ran to a place that no natural sweet could be found: the forest of mystery.  Much time passed, and the kingdom began to fell" +
					" into disrepair without any sign of the " + heroTitle + ".  Without an heir to the royal throne, the Royal Overseer would be in" +
					" charge of the land. " + villianName +"’s plan was coming to fruition!";
			//Get next logical progression in the story
			rand = generator.nextInt(2);
			if(rand == 0){
				nextOption=6;
			}
			else{
				nextOption=4;
			}
			break;
		//First Function of the Donor Case
		case 4:
			plot += "Knowing that avoiding sweets was the only way to save " + heroPosses +" life, the "+ heroTitle +" resigned themselves to their fate." +
					"  The "+ heroTitle +" struggled to find their way in the forest, and eventually collapsed at the base of a particularly large, hollow" +
					" tree trunk.  Just as " + heroPro + " had given up hope, a ferocious beast from the forest emerged from the tree: SMORG.  “I am SMORG!” " +
					"Smorg said, snorting.  Smorg was feared throughout the land as a particularly feisty dragon, responsible for many-a-local’s sheep" +
					" disappearance, and many-a barn fires.  But upon first look, the " + heroChar.name + " knew that this was not the case.  Smorg was but 2 feet" +
					" tall, had a tail that grew a fiery red, and a stomach that protruded far over his little dragon feet.  " + heroChar.name + ", upon reflecting on" +
					" this situation, realized that Smorg probably couldn’t fly 5 or 10 feet without having to stop for a break.  However, as it would be mean to be" +
					" disrespectful of a creature in the forest, "+ heroChar.name +" chose not to address Smorg’s appearance.  Instead, the "+ heroTitle +" pleaded for" +
					" Smorg’s help to avoid sweets.  “All is not as simple as you would think it,” snorted Smorg, who went on to explain what had happened while our " +
					"hero had exiled themselves.  “In order to regain your status and bring stability back to the kingdom from the evil " + villianName + ", you must " +
					"participate and win your kingdom’s Healthy Eating Competition, which is held every year exactly one week from today.”  Smorg, who was actually a" +
					" very well-intentioned dragon who had put his sheep-eating in the past behind him, described a most magnificent healthy eating training regiment" +
					" that would help the "+ heroTitle +" get into shape for the competition.  "+ heroChar.name +" would have to follow the regiment to the T if they wanted" +
					" to come out on top and win back the heart of the kingdom.";
			//Get next logical progression in the story
			nextOption=5;
			break;
		//Hero's Reaction Case
		case 5:
			//Get next logical progression in the story
			rand = generator.nextInt(2);
			if(rand == 0){
				plot+= "As it would turn out, Smorg was actually a brilliant cook.  Although " + heroChar.name + " hated broccoli, carrots, celery and cucumbers, " + heroPro +
					   " ate them for breakfast lunch and dinner under Smorg’s tutelage.  Within a week’s time, the "+ heroTitle +" was a lean, mean, vegetable eating machine." +
					   	"  It was time to face the music and return to the kingdom.";
				isBranchOver = true;
			}
			else{
				plot+= "As it would turn out, Smorg was a brilliant cook.  Unfortunately, all of the recipes he made, including his famous charred broccoli flambe, did not sit well" +
						" with the " + heroTitle + ", who lamented the healthy cooking.  Smorg, nice as he was, did not like complainers. Smorg warned the "+ heroTitle +" several times" +
						" to stop complaining, but the "+ heroTitle +" would not. So Smorg ate " + heroPro + ". You’d be surprised how easy it was for a little dragon to eat a fully grown" +
						" human being.  I suppose that is one of the benefits of being a magical creature.";
				nextOption=7;
			}
			break;
		//Difficult Task Case
		case 6:
			plot+= "Contrary to popular belief, " + heroChar.name + " was not in fact dead, but training in the forests.  Unable to resist the temptation" +
					" of sweets, the "+ heroTitle +" was surviving off of a steady diet of tree bark and grass.  Unfortunately, as dictated by human biology," +
					" tree bark and grass can not sustain a human for long.";
			//Get next logical progression in the story
			rand = generator.nextInt(2);
			if(rand == 0){
				nextOption=4;
			}
			else{
				nextOption=7;
			}
			break;
		//Receipt of Magical Donor Case
		case 7:
			rand = generator.nextInt(2);
			if(rand == 0){
				plot+= "With the "+ heroTitle +"’s training complete, Smorg released them from his broccoli-infused regiment.  As the " + heroTitle + " had been" +
						" especially studious during their training, Smorg withdrew from the stump of his tree trunk a " + objectName;
			}
			else{
				plot+= "As the " + heroTitle + " stumbled through the forest, " + heroPro + " fell at the base of an old hollow tree. Within it, emerged a " + objectName;
			}
			//Get next logical progression in the story
			nextOption=8;
			break;
		//All Paths Case
		case 8:
			switch(objectName){
			//If the object is Apple Pie
        	   case "Apple Pie":
        		   plot+= "The apple pie was made with apples made by the highest culinary chef in the land, and possessed cleansing properties that could purify whoever" +
        		   		" was lucky enough to eat it. Although the Apple Pie had been in existence for several thousand years, it somehow remained untouched by mold or any" +
        		   		" visible sign of aging. And it smelled nice! SWEET!";
        		   break;
        	   //If the object is Garden Snake
        	   case "Garden Snake":
        		   plot+="The garden snake had served as a royal confidant for many generations. Unfortunately, in order to hear its advice, one would have to allow the garden" +
        		   		" snake to whisper in their ear, which caused quite the ticklish sensation for those that were not iron willed. Further legend has it that if the user laughed," +
        		   		" the garden snake would bite them.";
        		   break;
        	   //If the object is Wooden Sword
        	   case "Wooden Sword":
        		   plot+= "The Wooden Sword had been passed down through generations of Royal Knights sworn to protect the kingdom, and was widely regarded as an item of extremely strong magical value." +
        		   		" Unfortunately, however, it was all a lie. The sword functioned as little more than a relic of the Royal Knights. It would probably fetch a good price on Medieval eBay.";
        		   break;
        	   //If the object is Magican's Wand
        	   case "Magican\'s Wand":
        		   plot += "The Magican's Wand was exceptionally efficient at casting the dreaded “bubble bobble” magic upon its victims, which would barrade them with bubbles. And these bubbles were serious - they" +
        		   		" weren’t made of child friendly soap, and would sting the victims eyes if they weren’t shielded. There’s almost nothing worse than that.";

        		   break;
        	   //If the object is Ball of Yarn
        	   case "Ball of Yarn":
        		   plot += "The Ball of Yarn was handed down throughout several generations of the feral cat-people clan of Abilene. Legend has it that once the yarn holder took ownership of the ball, the" +
        		   		" length of the yarn dictated how long their life would last. The yarn ball has been known to mysteriously grow and shrink upon being received by a new owner.";
        		   break;
        	   //If the object is Plastic Slippers
        	   case "Plastic Slippers":
        		   plot+="The odd plastic slippers gave the wearer an intuitive knowledge of all formal and informal dance practices of the local population. Some say that plastic is one of the most valuable and rarest" +
        		   		" materials in the land.";
        		   break;
			}
			//Get next logical progression in the story
			nextOption=9;
			break;
		//Interdiction Case
		case 9:
			rand = generator.nextInt(2);
			if(rand == 0){
				if(objectName == "Apple Pie"){
					plot+= "Our hero thanked Smorg for the gift, and immediately went face-down into it. In a horrific yet" +
							" majestic display of gluttonous prowess, the " + heroTitle + " ate through the apple pie in a matter" +
							" of seconds. With a wink and a nod, but no words exchanged, " + heroChar.name + " then walked away from " +
							"the mighty Smorg, and towards the direction of the final conflict.";
				}
				else{
					plot+="Our hero thanked Smorg for "+ heroPosses +" gift, walked in the direction of the castle, and, once" +
							" out of eyesight, tossed it to the ground.  The " + heroTitle + " didn’t really have time to carry" +
							" anything of little value to them.  Smorg was nice and all, but the last thing " + heroPro + " needed" +
							" was to carry around a " + objectName + ". It was time to win the competition.";
				}
			}
			else{
				if(objectName == "Apple Pie"){
					plot+= "Our hero eyed up the apple pie, legendary as it was, and knew exactly what to do. With the gaze of a hawk" +
							" eyeing its prey from a mile high, the " + heroTitle + " dove into the pie face-first, ingesting it like some" +
							" sort of black hole digests whatever unfortunately gets in its way. The pie was invigorating. Victory would be "
							+ heroPosses +"!"; 
				}
				else {
					plot+= "”Neat”, said our hero, before continuing towards the castle to reclaim respect from the kingdom.";
				}
			}
			//Get next logical progression in the story
			nextOption=10;
			break;
		//Struggle Case
		case 10:
			plot+= "The day of the Kingdom’s Healthy Eating Competition was upon us. Our hero, the missing " + heroTitle + ", " 
					+ heroChar.name + ", strode back into the kingdom with a wink and a nod, entering their name into the competition." +
					" The competition, of course, was chaired by " + villianName + ", as the overseer of the Royal Court. Thinking that "
					+ heroChar.name + " was ill-prepared to ingest healthy food, " + villianName + " brought forth enough broccoli platters" +
					" to cover the entire kingdom (not literally though - that would be pretty much impossible). The contestants lined up and" +
					" began the feast.  The broccoli platters were first, followed by mounds of celery, then cabbage, carrots, and finally cucumbers.";
			if(objectName == "Apple Pie"){
				plot+= "But the " + heroTitle + " ate through it all much faster than the competition, finishing the meal with a triumphant burp.  The " +
						"crowd cheered.";
				 plot+= villianName + " hung " + villainPosses + " head in shame. They had been defeated. The " + heroTitle + " had bested their challenge," +
				 		" and captured the heart of the kingdom. ";
			}
			else{
				plot+= "But try as they might, the " + heroTitle + " could not see their way through the feast. The food was just too much for them.";
			}
			isBranchOver = true;
			break;
		}
		
		return plot;
	}
	
	//All the private objects of the story
	public Hero heroChar; //The hero of the story
	public char branchSet; //Beginning, Middle, End
	public boolean isBranchOver; //Sets the progress of the branch. if true, the branch is complete, the story moves to the next step
	public boolean isConflict; //If false, skip to end
	public int storyMode; //Determines which beginning mode was chosen
	public int nextOption; //Integer that hold the next story action
	
	//About the villain
	public boolean isVillainPresent; //checks if villain is present (if so, check if dead. if not, move to introduce villain)
	public boolean isVillainMale; //Gender of the villain
	public boolean isVillainDead; //If dead, moves to epilogue
	public String villianName; //String of the name
	

	//symbolic object type
	public String objectName; //Name of object		
	public String objectType; //sentimental, magical, historical 
	public boolean isObjUnbreakable; //if object isn’t indestructable, set health
	public boolean isobjectBroken; //If the object is no longer of use		
	public String objectAction; //action of object


	//other supporting characters (SMORG)
	public boolean isSmorgAlive; //If the SC is alive
	public boolean isSmorgInjured; //If the SC is injured
	public boolean isSmorgFriendly; //If the SC is friendly
}
