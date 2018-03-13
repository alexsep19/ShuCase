package shu.client.panForm;

import com.google.gwt.user.client.ui.Widget;

import shu.client.tools.HPanel;

public class PanForm extends HPanel{
//      private static PanForm instance;
      public PanForm(int w, int h, String header){
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
      
      public Widget setContent(){return this;};
      public Widget setContent(Widget widget){
    	  setContentWidget(widget);
    	  return this;
      }
//	public PanForm(int w, int h, String header){
//		super(w, h, header);
//		addHeader();
//		setContentWidget();
//	}
    
}
