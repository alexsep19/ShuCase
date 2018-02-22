package shu.client.panForm;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

import shu.client.startpoint;

public class PanForm extends Composite{
	
	public PanForm(){
	   DockLayoutPanel pan = new DockLayoutPanel(Unit.PX);
	   
	   HTMLPanel title = new HTMLPanel("Форма");
	   pan.addNorth( title, startpoint.TITLE_WIDTH);
	   pan.add(new HTMLPanel("Фjjjjjjjjjj"));
	   pan.setVisible(true);
	   initWidget(pan);
	   pan.setStylePrimaryName("titleBorder");
	   title.setStyleName("titleHeader");
	}
}
