package edu.ramapo.KristinaCorrado.fairytalefactory;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void createDialog(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.dialog_title);
    	//Input for the dialog
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.dialoglayout, null);
    	builder.setView(dialoglayout);
		// Add the buttons
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		               // User clicked OK button - get user input
		        	   
		        	   Story fairyTale = new Story(); //Instance of the story
		        	   RadioButton rg = (RadioButton) dialoglayout.findViewById(R.id.maleHero);
		        	   if(rg.isChecked()){
		        		   fairyTale.heroChar.isMale = true;
		        	   }
		        	   else {
		        		   fairyTale.heroChar.isMale = false;
		        	   }
		        	   rg = (RadioButton) dialoglayout.findViewById(R.id.maleVillian);
		        	   if(rg.isChecked()){
		        		   fairyTale.isVillainMale = true;
		        	   }
		        	   else {
		        		   fairyTale.isVillainMale = false;
		        	   }
		        	   EditText inputVal = (EditText) dialoglayout.findViewById(R.id.heroName);
		        	   fairyTale.heroChar.name = inputVal.getText().toString();
		        	   inputVal = (EditText) dialoglayout.findViewById(R.id.villianHero);
		        	   fairyTale.villianName = inputVal.getText().toString();
		        	   Spinner objSpinner = (Spinner) dialoglayout.findViewById(R.id.object);
		        	   fairyTale.objectName = objSpinner.getSelectedItem().toString();
		        	   //Based on objectName get the object action
		        	   switch(fairyTale.objectName){
		        	   //If the object is Apple Pie
		        	   case "Apple Pie":
		        		   fairyTale.objectAction = "purify whoever was lucky enough to eat it";
		        		   fairyTale.objectType = "historical"; 
		        		   fairyTale.isObjUnbreakable = false; 
		        		   fairyTale.isobjectBroken = false; 		
		        		   break;
		        	   //If the object is Garden Snake
		        	   case "Garden Snake":
		        		   fairyTale.objectAction = "serve as a royal confidant unless the user laughed";
		        		   fairyTale.objectType = "magical"; 
		        		   fairyTale.isObjUnbreakable = true; 
		        		   fairyTale.isobjectBroken = false;		
		        		   break;
		        	   //If the object is Wooden Sword
		        	   case "Wooden Sword":
		        		   fairyTale.objectAction = "protect the kingdom, and was widely regarded as an item of extremely strong magical value";
		        		   fairyTale.objectType = "sentimental"; 
		        		   fairyTale.isObjUnbreakable = false; 
		        		   fairyTale.isobjectBroken = false;
		        		   break;
		        	   //If the object is Magican's Wand
		        	   case "Magican\'s Wand":
		        		   fairyTale.objectAction = "cast the dreaded “bubble bobble” magic upon its victims, which would barrade them with bubbles";
		        		   fairyTale.objectType = "magical"; 
		        		   fairyTale.isObjUnbreakable = false; 
		        		   fairyTale.isobjectBroken = false;
		        		   break;
		        	   //If the object is Ball of Yarn
		        	   case "Ball of Yarn":
		        		   fairyTale.objectAction = "dictate how long their life would last based on length of the yarn";
		        		   fairyTale.objectType = "sentimental"; 
		        		   fairyTale.isObjUnbreakable = false; 
		        		   fairyTale.isobjectBroken = false;
		        		   break;
		        	   //If the object is Plastic Slippers
		        	   case "Plastic Slippers":
		        		   fairyTale.objectAction = "give the wearer an intuitive knowledge of all formal and informal dance practices of the local population";
		        		   fairyTale.objectType = "historical"; 
		        		   fairyTale.isObjUnbreakable = true; 
		        		   fairyTale.isobjectBroken = false;
		        		   break;
		        	   }
		        	   
		        	   //Get the passed information from the game and call the story activity
		        	   Intent intent = new Intent(MainActivity.this, StoryActivity.class);
		        	   intent.putExtra("Story", fairyTale);
		         	   startActivity(intent);
		     		   dialog.dismiss();
		     		   return;
		        	   
		           }
		       });
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		               // Close the dialog
		        	   dialog.dismiss();
		           }
		       });

		// Open the AlertDialog
		builder.show();
	}
	
	
}
