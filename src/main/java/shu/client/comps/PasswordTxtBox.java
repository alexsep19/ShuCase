package shu.client.comps;

import com.google.gwt.user.client.ui.PasswordTextBox;

public class PasswordTxtBox extends PasswordTextBox{

	public PasswordTxtBox() {
	}

	public void setMask(boolean mask){
	   getElement().setAttribute("type", mask? "password": "text");
	}
}
