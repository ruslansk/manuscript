package org.ma3x.manuscript.control;

import org.ma3x.manuscript.control.backup.BackupControl;
import org.ma3x.manuscript.control.bookmark.Bookmark;
import org.ma3x.manuscript.control.bookmark.BookmarkControl;
import org.ma3x.manuscript.control.comparetranslations.CompareTranslationsControl;
import org.ma3x.manuscript.control.document.DocumentControl;
import org.ma3x.manuscript.control.download.DownloadControl;
import org.ma3x.manuscript.control.footnoteandref.FootnoteAndRefControl;
import org.ma3x.manuscript.control.link.LinkControl;
import org.ma3x.manuscript.control.mynote.MyNote;
import org.ma3x.manuscript.control.mynote.MyNoteControl;
import org.ma3x.manuscript.control.page.CurrentPageManager;
import org.ma3x.manuscript.control.page.PageControl;
import org.ma3x.manuscript.control.page.PageTiltScrollControl;
import org.ma3x.manuscript.control.readingplan.ReadingPlanControl;
import org.ma3x.manuscript.control.search.SearchControl;
import org.ma3x.manuscript.control.speak.SpeakControl;

//TODO replace with ioc (maybe)
/** allow access to control layer
 *
 * @author denha1m
 *
 */
public class ControlFactory {
	//TODO move instance creation here
	private CurrentPageManager currentPageManager = CurrentPageManager.getInstance();
	private DocumentControl documentControl = new DocumentControl();
	private PageControl pageControl = new PageControl();
	private PageTiltScrollControl pageTiltScrollControl = new PageTiltScrollControl();
	private LinkControl linkControl = new LinkControl();
	private SearchControl searchControl = new SearchControl();
	private Bookmark bookmarkControl = new BookmarkControl();
	private MyNote mynoteControl = new MyNoteControl();
	private DownloadControl downloadControl = new DownloadControl();
	private SpeakControl speakControl = new SpeakControl();
	private ReadingPlanControl readingPlanControl = new ReadingPlanControl();
	private CompareTranslationsControl compareTranslationsControl = new CompareTranslationsControl();
	private FootnoteAndRefControl footnoteAndRefControl = new FootnoteAndRefControl();
	private BackupControl backupControl = new BackupControl();
	
	private static ControlFactory singleton = new ControlFactory();
	
	public static ControlFactory getInstance() {
		return singleton;
	}
	
	private ControlFactory() {
		// inject dependencies
		pageControl.setCurrentPageManager(this.currentPageManager);
		readingPlanControl.setSpeakControl(this.speakControl);
		compareTranslationsControl.setCurrentPageManager(currentPageManager);
		footnoteAndRefControl.setCurrentPageManager(currentPageManager);
	}
	
	public DocumentControl getDocumentControl() {
		return documentControl;		
	}

	public PageControl getPageControl() {
		return pageControl;		
	}

	public PageTiltScrollControl getPageTiltScrollControl() {
		return pageTiltScrollControl;
	}

	public SearchControl getSearchControl() {
		return searchControl;		
	}

	public CurrentPageManager getCurrentPageControl() {
		return currentPageManager;		
	}

	public LinkControl getLinkControl() {
		return linkControl;
	}

	/**
	 * @return the bookmarkControl
	 */
	public Bookmark getBookmarkControl() {
		return bookmarkControl;
	}
	
	public MyNote getMyNoteControl() {
		return mynoteControl;
	}

	public DownloadControl getDownloadControl() {
		return downloadControl;
	}

	public SpeakControl getSpeakControl() {
		return speakControl;
	}

	public ReadingPlanControl getReadingPlanControl() {
		return readingPlanControl;
	}

	public CompareTranslationsControl getCompareTranslationsControl() {
		return compareTranslationsControl;
	}

	public FootnoteAndRefControl getFootnoteAndRefControl() {
		return footnoteAndRefControl;
	}

	public BackupControl getBackupControl() {
		return backupControl;
	}
}
