package shu.client.nav;

import com.google.gwt.user.client.ui.FlowPanel;

import shu.client.TitlePan;

public class NavPan1 extends TitlePan{

	public NavPan1(FlowPanel center) {
		super("Навигация");
		getPan().add(new Navs(center));
	}

}
