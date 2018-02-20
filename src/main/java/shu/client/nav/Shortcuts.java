package shu.client.nav;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.core.client.GWT;

public class Shortcuts extends ResizeComposite {
	  interface Binder extends UiBinder<DockLayoutPanel, Shortcuts> { }
	  private static final Binder binder = GWT.create(Binder.class);

	  @UiField Navs navs;
//	  @UiField Tasks tasks;
//	  @UiField Contacts contacts;

	  /**
	   * Constructs a new shortcuts widget using the specified images.
	   * 
	   * @param images a bundle that provides the images for this widget
	   */
	  public Shortcuts() {
	    initWidget(binder.createAndBindUi(this));
	  }
}
