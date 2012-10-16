package org.ma3x.manuscript.view.activity.speak;

import org.ma3x.manuscript.control.ControlFactory;
import org.ma3x.manuscript.control.speak.NumPagesToSpeakDefinition;
import org.ma3x.manuscript.control.speak.SpeakControl;
import org.ma3x.manuscript.view.activity.base.ActivityBase;
import org.ma3x.manuscript.view.activity.base.Dialogs;
import org.ma3x.manuscript.view.activity.page.MainBibleActivity;

import org.ma3x.manuscript.activity.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/** Allow user to enter search criteria
 * 
 * @author Martin Denham [mjdenham at gmail dot com]
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's author.
 */
public class Speak extends ActivityBase {
	
    private NumPagesToSpeakDefinition[] numPagesToSpeakDefinitions;
    
    private CheckBox mQueueCheckBox;
    private CheckBox mRepeatCheckBox;
    
    private SpeakControl speakControl;
    
	private static final String TAG = "Speak";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Displaying Search view");
        setContentView(R.layout.speak);
        
        speakControl = ControlFactory.getInstance().getSpeakControl();
        
        // set title of chapter/verse/page selection
        numPagesToSpeakDefinitions = speakControl.getNumPagesToSpeakDefinitions();
        
        // set a suitable prompt for the different numbers of chapters
        for (NumPagesToSpeakDefinition defn : numPagesToSpeakDefinitions) {
        	RadioButton numChaptersCheckBox = (RadioButton)findViewById(defn.getRadioButtonId());

        	numChaptersCheckBox.setText(defn.getPrompt());
        }
        
        // set defaults for Queue and Repeat
        mQueueCheckBox = (CheckBox)findViewById(R.id.queue);
        mRepeatCheckBox = (CheckBox)findViewById(R.id.repeat);
        mQueueCheckBox.setChecked(true);
        mRepeatCheckBox.setChecked(false);
    
        Log.d(TAG, "Finished displaying Speak view");
    }

    public void onSpeak(View v) {
    	Log.i(TAG, "CLICKED");
    	try {
	    	speakControl.speak(getSelectedNumPagesToSpeak(), isQueue(), isRepeat());
	    	
	    	returnToMainScreen();
    	} catch (Exception e) {
    		Dialogs.getInstance().showErrorMsg(R.string.error_occurred);
    	}
    }
    
    public void onStop(View v) {
    	Log.i(TAG, "CLICKED");
    	speakControl.stop();
		returnToMainScreen();
    }

    private NumPagesToSpeakDefinition getSelectedNumPagesToSpeak() {
        RadioGroup chaptersRadioGroup = (RadioGroup)findViewById(R.id.numChapters);
        int selectedId = chaptersRadioGroup.getCheckedRadioButtonId();
        
        for (NumPagesToSpeakDefinition defn : numPagesToSpeakDefinitions) {
        	if (selectedId == defn.getRadioButtonId()) {
        		return defn;
        	}
        }
        // error - should not get here
   		return numPagesToSpeakDefinitions[0];
    }

    private boolean isQueue() {
    	return mQueueCheckBox.isChecked();
    }
    
    private boolean isRepeat() {
    	return mRepeatCheckBox.isChecked();
    }

    private void returnToMainScreen() {
    	// just pass control back to teh main screen
    	Intent resultIntent = new Intent(this, MainBibleActivity.class);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
}
