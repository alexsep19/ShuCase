package shu.client.tools;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import shu.client.startpoint;

public class TitlePan2 extends Composite{
	private LayoutPanel pan = new LayoutPanel();
	
	public TitlePan2() {}
	public TitlePan2(String title) {
		   HTMLPanel titlePan = new HTMLPanel(title);
		   pan.add( titlePan);
//		   pan.setVisible(true);
		   initWidget(pan);
		   pan.setStyleName("titleBorder");
		   titlePan.setStyleName("titleHeader");

	}
	public void addBody(Widget w){
    	pan.add(w);
    }

}
