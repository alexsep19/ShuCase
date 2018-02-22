package shu.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

abstract public class TitlePan extends Composite{
	private DockLayoutPanel pan = new DockLayoutPanel(Unit.PX);
	
	public DockLayoutPanel getPan() {
		return pan;
	}

	public void setPan(DockLayoutPanel pan) {
		this.pan = pan;
	}

	public TitlePan() {	}
	
	public TitlePan(String title) {
		   HTMLPanel titlePan = new HTMLPanel(title);
		   pan.addNorth( titlePan, startpoint.TITLE_WIDTH);
//		   pan.add(new HTMLPanel("ывпыпапаj"));
		   pan.setVisible(true);
		   initWidget(pan);
		   pan.setStylePrimaryName("titleBorder");
		   titlePan.setStyleName("titleHeader");

	}

}
