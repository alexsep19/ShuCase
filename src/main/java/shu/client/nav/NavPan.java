package shu.client.nav;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

import shu.client.startpoint;

public class NavPan extends Composite{
	
    public NavPan (FlowPanel center) {
      DockLayoutPanel pan = new DockLayoutPanel(Unit.PX);
  	  HTMLPanel title = new HTMLPanel("Навигация");
  	  pan.addNorth( title, startpoint.TITLE_WIDTH);
  	  pan.add(new Navs(center));
  	  initWidget(pan);
	  pan.setStylePrimaryName("titleBorder");
	  title.setStyleName("titleHeader");

}
}
