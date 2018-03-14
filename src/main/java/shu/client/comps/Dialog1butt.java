package shu.client.comps;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Dialog1butt extends DialogBox {

	public Dialog1butt(String header) {
		setText(header);
	    setAnimationEnabled(true);
	    setGlassEnabled(true);
	    VerticalPanel content = new VerticalPanel();
	    content.setSpacing(4);
//	    HTML details = new HTML("SSSSSSSSSSSSSS"); 
	    Button btClose = new Button("Закрыть", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
	    Widget details = getDetails();
	    content.add(details);
	    content.setCellHorizontalAlignment(details, HasHorizontalAlignment.ALIGN_CENTER);
	    content.add(btClose);
	    content.setCellHorizontalAlignment(btClose, HasHorizontalAlignment.ALIGN_CENTER);
	    setWidget(content);
	}
	
	protected Widget getDetails(){return null;}
	
	@Override
	protected void onPreviewNativeEvent(NativePreviewEvent preview) {
	    super.onPreviewNativeEvent(preview);

	    NativeEvent evt = preview.getNativeEvent();
	    if (evt.getType().equals("keydown")) {
	      // Use the popup's key preview hooks to close the dialog when either
	      // enter or escape is pressed.
	      switch (evt.getKeyCode()) {
	        case KeyCodes.KEY_ENTER:
	        case KeyCodes.KEY_ESCAPE:
	          hide();
	          break;
	      }
	    }
	}

}
