package edu.ramapo.KristinaCorrado.fairytalefactory;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class StoryActivity extends ActionBarActivity {
	
	private Story fairyTale = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);
		
		//Get the passed information from the game
	    Intent intent = getIntent();
	    Story passedStoryData = (Story)intent.getSerializableExtra("Story");
	    fairyTale = passedStoryData;
	    
	    //Get the story for the fairy tale
	    String story = fairyTale.storyTeller();
	    
	    //Put in story text
	    TextView tv=(TextView)findViewById(R.id.storyText);
	    tv.setText(story);
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.story, menu);
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
	
	//When next button is selected
	public void clickNext(View view){
		//Continue the story if needed
		//Get the passed information from the game and call the story activity
		if(fairyTale.branchSet != 'E' && fairyTale.isBranchOver != true ){
			Intent intent = new Intent(StoryActivity.this, StoryActivity.class);
			intent.putExtra("Story", fairyTale);
			startActivity(intent);
			return;
		}
		//If the story is over
		else{
			Intent intent = new Intent(StoryActivity.this, EndActivity.class);
			startActivity(intent);
			return;
		}
	}
}
