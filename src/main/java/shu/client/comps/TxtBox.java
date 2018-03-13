package shu.client.comps;

import com.google.gwt.user.client.ui.TextBox;

public class TxtBox extends TextBox {

	public TxtBox() {
	}

	public void setPlaceHolder(String txt){
		getElement().setPropertyString("placeholder", txt);
	}
}
