package shu.client.tools;

import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class HPanel extends HeaderPanel{
	Button _b;
    Label _header = new Label();
    
	public HPanel(int w, int h, String text) {
        super();
        setPixelSize(w, h);
        _header.setText(text);
        getElement().getStyle().setProperty("border", "1px solid #003366");
    }

	public void setHeader(String text){
        _header.setText(text);
    }
	
	public void addHeader(){
        HorizontalPanel pan = new HorizontalPanel();
        pan.add(_header);
        pan.getElement().getStyle().setBackgroundColor("#cfcfcf");
        pan.getElement().getStyle().setColor("black");
        pan.getElement().getStyle().setProperty("borderBottom", "1px solid #003366");
        pan.getElement().getStyle().setPaddingRight( 4, Unit.PX);
        pan.getElement().getStyle().setPaddingLeft( 4, Unit.PX);
        pan.getElement().getStyle().setPaddingBottom( 4, Unit.PX);
        pan.setHeight("27px");

        _b = new Button();
        _b.addClickHandler( new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                handlerBody(event);
            }
        });
        _b.setPixelSize(16, 16);
//        pan.add(_b);
        HorizontalPanel pan2 = new HorizontalPanel();
        pan2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        pan2.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        pan.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        pan.setWidth("100%");
        pan2.setWidth("100%");
        pan2.add(_b);
        pan.add(pan2);
        setHeaderWidget(pan);
    }
	
//	 public void setButVisible(boolean e){
//	        b.setVisible(e);
//	    }
	protected void handlerBody(ClickEvent event){};
//	public void setBody(Widget w){
//        setContentWidget(w);
//    }
}
