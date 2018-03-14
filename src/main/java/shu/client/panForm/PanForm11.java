package shu.client.panForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;

import shu.client.tools.HPanel;

public class PanForm11 extends HPanel{
//      private static PanForm instance;
      public PanForm11(int w, int h, String header){
    	  super(w, h, header);
    	  addHeader();
      }
	
//      public static PanForm getInstance(int w, int h, String header){
//    	  if (instance == null) {
//    		  instance = new PanForm(w, h, header);
//    		  instance.addHeader();
//    	  }
//    	  return instance;
//      }
      
      public void setContent(){};
//      public Widget setContent(){return this;};
//      public Widget setContent(Widget widget){
//    	  setContentWidget(widget);
//    	  return this;
//      }
      
//      public void addBut(ClickHandler clickHandler){
//      }
//	public PanForm(int w, int h, String header){
//		super(w, h, header);
//		addHeader();
//		setContentWidget();
//	}

   
}
