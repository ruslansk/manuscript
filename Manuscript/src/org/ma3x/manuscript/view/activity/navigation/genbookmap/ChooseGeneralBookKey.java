package org.ma3x.manuscript.view.activity.navigation.genbookmap;

import java.util.List;


import org.crosswire.jsword.passage.Key;
import org.ma3x.manuscript.control.ControlFactory;
import org.ma3x.manuscript.control.page.CurrentGeneralBookPage;
import org.ma3x.manuscript.control.page.CurrentPageManager;

import android.util.Log;

/** show a list of keys and allow to select an item
 * 
 * @author Martin Denham [mjdenham at gmail dot com]
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's author.
 */
public class ChooseGeneralBookKey extends ChooseKeyBase {

	private static final String TAG = "ChooseGeneralBookKey";
	
	@Override
	protected Key getCurrentKey() {
		
		return getCurrentGeneralBookPage().getKey();
	}

	@Override
	protected List<Key> getKeyList() {
		return getCurrentGeneralBookPage().getCachedGlobalKeyList();
	}

	@Override
    protected void itemSelected(Key key) {
    	try {
    		CurrentPageManager.getInstance().getCurrentGeneralBook().setKey(key);
    	} catch (Exception e) {
    		Log.e(TAG, "error on select of gen book key", e);
    	}
    }

	private CurrentGeneralBookPage getCurrentGeneralBookPage() {
    	return ControlFactory.getInstance().getCurrentPageControl().getCurrentGeneralBook();
    }
}
