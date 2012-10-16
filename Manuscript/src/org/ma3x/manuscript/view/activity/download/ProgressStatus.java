package org.ma3x.manuscript.view.activity.download;

 import org.ma3x.manuscript.view.activity.base.ProgressActivityBase;

import org.ma3x.manuscript.activity.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**Show all Progress status
 * see BibleDesktop JobsProgressBar for example use
 * 
 * @author Martin Denham [mjdenham at gmail dot com]
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's author.
 */
public class ProgressStatus extends ProgressActivityBase {
	private static final String TAG = "ProgressStatus";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Displaying "+TAG+" view");
        setContentView(R.layout.progress_status);

        Log.d(TAG, "Finished displaying Search Index view");
    }

    public void onOkay(View v) {
    	Log.i(TAG, "CLICKED");
    	Intent resultIntent = new Intent(this, ProgressStatus.class);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();    
    }
}