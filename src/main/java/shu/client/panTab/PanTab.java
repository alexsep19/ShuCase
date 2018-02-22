package shu.client.panTab;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

import shu.client.startpoint;

public class PanTab  extends Composite{
	DockLayoutPanel pan = new DockLayoutPanel(Unit.PX);

	public DockLayoutPanel getPan() {
		return pan;
	}

	public void setPan(DockLayoutPanel pan) {
		this.pan = pan;
	}

	public PanTab() {
		   
		   HTMLPanel title = new HTMLPanel("Таблица");
		   pan.addNorth( title, startpoint.TITLE_WIDTH);
		   pan.add(new HTMLPanel("ывпыпапаj"));
		   pan.setVisible(true);
		   initWidget(pan);
		   pan.setStylePrimaryName("titleBorder");
		   title.setStyleName("titleHeader");
	}

}
