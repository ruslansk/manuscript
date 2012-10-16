package org.ma3x.manuscript.control.event.apptobackground;

import java.util.EventListener;

public interface AppToBackgroundListener extends EventListener {
	void applicationNowInBackground(AppToBackgroundEvent e);
}
