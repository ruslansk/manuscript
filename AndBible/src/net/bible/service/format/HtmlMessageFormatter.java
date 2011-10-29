package net.bible.service.format;

import net.bible.android.SharedConstants;
import net.bible.service.common.CommonUtils;

/** prepare an error message for display in a WebView
 * 
 * @author denha1m
 *
 */
public class HtmlMessageFormatter {

	private static final String NIGHT_STYLESHEET = "<link href='file:///android_asset/"
			+ SharedConstants.NIGHT_MODE_STYLESHEET
			+ "' rel='stylesheet' type='text/css'/>";
	
	private static final String NIGHT_HEADER = "<html><head>"+NIGHT_STYLESHEET+"</head><body>";
	private static final String NIGHT_FOOTER = "</body></html>";
	
	private static final String TAG = "HtmlmessageFormatter";
	
	/** wrap text with nightmode css if required
	 */
	public static String format(String text) {
		boolean isNightMode = CommonUtils.getSharedPreferences().getBoolean("night_mode_pref", false);
		
		String formattedText = "";
		
		// only require special formatting for nightmode
		if (!isNightMode) {
			formattedText = text;
		} else {
			formattedText = NIGHT_HEADER+text+NIGHT_FOOTER;
		}
		return formattedText;
	}
}