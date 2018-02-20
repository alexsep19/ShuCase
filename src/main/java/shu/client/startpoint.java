package shu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import shu.client.nav.Shortcuts;
import shu.client.panForm.PanForm;

import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class startpoint implements EntryPoint {
//	interface Binder extends UiBinder<DockLayoutPanel, startpoint> { }
	public static final int TITLE_WIDTH = 26;
	interface GlobalResources extends ClientBundle {
	    @Source("global.gss")
	    CssResource css();
	  }
//	private static final Binder binder = GWT.create(Binder.class);
//	  @UiField TopPanel topPanel;
//	  @UiField Shortcuts shortcuts;
	  
  public void onModuleLoad() {
	// Inject global styles.
	    GWT.<GlobalResources>create(GlobalResources.class).css().ensureInjected();
    // Create the UI defined in startpoint.ui.xml.
//	    DockLayoutPanel outer = binder.createAndBindUi(this);
	    DockLayoutPanel outer = new DockLayoutPanel(Unit.PX);
	    outer.addNorth(new TopPanel(), 40);
	    SplitLayoutPanel split = new SplitLayoutPanel();
	    split.addWest(new Shortcuts(), 192);
	       DockLayoutPanel pan = new DockLayoutPanel(Unit.PX);
		   HTMLPanel title = new HTMLPanel("Форма");
		   pan.addNorth( title, startpoint.TITLE_WIDTH);
		   pan.add(new HTMLPanel("Фjjjjjjjjjj"));
	    split.add(pan);
	    outer.add(split);

	 // Get rid of scrollbars, and clear out the window's built-in margin,
	    // because we want to take advantage of the entire client area.
	    Window.enableScrolling(false);
	    Window.setMargin("0px");
	    
	 // Add the outer panel to the RootLayoutPanel, so that it will be
	    // displayed.
	    RootLayoutPanel root = RootLayoutPanel.get();
	    root.add(outer);
  }
}
