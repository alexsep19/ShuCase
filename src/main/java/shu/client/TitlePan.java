package shu.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class TitlePan extends Composite{
	private DockLayoutPanel pan = new DockLayoutPanel(Unit.PX);
	
	public TitlePan() {	}
	
	public TitlePan(String title) {
		   HTMLPanel titlePan = new HTMLPanel(title);
		   pan.addNorth( titlePan, startpoint.TITLE_WIDTH);
		   pan.setVisible(true);
		   initWidget(pan);
		   pan.setStyleName("titleBorder");
		   titlePan.setStyleName("titleHeader");

	}
    public void addBody(Widget w){
    	pan.add(w);
    }
}
