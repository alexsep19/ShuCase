package shu.client.nav;

import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import shu.client.tools.TitlePan;

public class NavPan extends TitlePan{

	public NavPan(SimpleLayoutPanel center) {
		super("Навигация");
		addBody(new Navs(center));
	}

}
