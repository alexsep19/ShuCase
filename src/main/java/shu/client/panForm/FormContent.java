package shu.client.panForm;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.datepicker.client.DateBox;

import shu.client.comps.Dialog1butt;
import shu.client.comps.PasswordTxtBox;
import shu.client.comps.TxtBox;
import shu.client.comps.HPanel;

public class FormContent extends Composite{
	  TxtBox tbSurname = new TxtBox();
	  TxtBox tbName = new TxtBox();
	  CheckBox turnField = new CheckBox("Вкл/Выкл Field");
	  CheckBox turnCheck = new CheckBox("Вкл/Выкл ChkBox");

	public FormContent() {
		  FlexTable ft = new FlexTable();
		  FlexCellFormatter fcf = ft.getFlexCellFormatter();
		  ft.setCellPadding(2);
		  HPanel panForm1 = new HPanel(200, 150, "header1"){
			  @Override
			  public HPanel setContent(){
				  tbSurname.setWidth("100px");
				  tbSurname.setMaxLength(30);
				  tbSurname.setPlaceHolder("placeholder");
				  tbName.setWidth("100px");
				  tbName.setMaxLength(30);
				  tbName.setPlaceHolder("tbName");
				  tbName.setValue("value");
				  turnField.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
						@Override
						public void onValueChange(ValueChangeEvent<Boolean> event) {
							tbName.setEnabled(event.getValue());
						}
					  });
				  turnField.setValue(true, true);
				  turnCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						turnField.setEnabled(event.getValue());
					}
				  });
				  turnCheck.setValue(true, true);

				  FlexTable layout = new FlexTable();
//				  FlexCellFormatter layoutFormat = layout.getFlexCellFormatter();
				  layout.setCellPadding(2);
				  layout.setHTML(0, 0, "Фамилия");
				  layout.setWidget(0, 1, tbSurname);
				  layout.setHTML(1, 0, "Имя");
				  layout.setWidget(1, 1, tbName);
				  layout.setWidget(2, 1, turnCheck);
				  layout.setWidget(3, 1, turnField);
			      setContentWidget(layout);
			      return this;
			  }
		  	}.setContent();
		  panForm1.addBut(new ClickHandler() {
			  @Override
			  public void onClick(ClickEvent event) {
				  Dialog1butt dialog1butt = new Dialog1butt("ФФФФФФФФФФФ"){
					  @Override
					  protected Widget getDetails(){
						  FlexTable table = new FlexTable();
						  table.setCellPadding(2);
						  table.setHTML(0, 0, tbSurname.getName());
						  table.setHTML(0, 1, tbSurname.getValue());
						  table.setHTML(1, 0, tbName.getName());
						  table.setHTML(1, 1, tbName.getValue());
						  table.setHTML(2, 0, turnField.getName());
						  table.setHTML(2, 1, turnField.getValue().toString());
						  table.setHTML(3, 0, turnCheck.getName());
						  table.setHTML(3, 1, turnCheck.getValue().toString());
						  return table;
					  }
				  };
				  dialog1butt.center();
				  dialog1butt.show();
			  }
		  });
		  ft.setWidget(0, 0, panForm1); 
		  
		  HPanel panForm2 = new HPanel(200, 150, "header2"){
			  @Override
			  public HPanel setContent(){
				  PasswordTxtBox tbPass = new PasswordTxtBox(); 
				  tbPass.setWidth("100px");
				  tbPass.setMaxLength(30);
				  
				  ListBox dropBox = new ListBox();
				  dropBox.addItem("111111");
				  dropBox.addItem("222222");
				  dropBox.addItem("0000000");
				  
				  DateBox datebox = new DateBox(); 
				  DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd.MM.yyyy"); 
				  datebox.setFormat(new DateBox.DefaultFormat(dateFormat));
				  datebox.getDatePicker().setYearArrowsVisible(true);
				  datebox.setWidth("100px");
//				  datebox.setsetMaxLength(10);
				  
				  CheckBox maskField = new CheckBox("show text");
				  maskField.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
						@Override
						public void onValueChange(ValueChangeEvent<Boolean> event) {
							tbPass.setMask(!event.getValue());
						}
					  });
				  maskField.setValue(false, true);
				  
				  CheckBox enblFields = new CheckBox("Вкл/Выкл");
				  enblFields.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
						@Override
						public void onValueChange(ValueChangeEvent<Boolean> event) {
							dropBox.setEnabled(event.getValue());
							datebox.setEnabled(event.getValue());
						}
					  });
				  enblFields.setValue(true, true);
				  
				  FlexTable layout = new FlexTable();
				  layout.setCellPadding(2);
				  layout.setHTML(0, 0, "password");
				  layout.setWidget(0, 1, tbPass);
				  layout.setWidget(1, 0, maskField);
				  layout.setWidget(1, 1, enblFields);
				  layout.setHTML(2, 0, "dropbox");
				  layout.setWidget(2, 1, dropBox);
				  layout.setHTML(3, 0, "date");
				  layout.setWidget(3, 1, datebox);
                setContentWidget(layout);
		      return this;

			  }
		  }.setContent();
//		  panForm2.setContent();
		  ft.setWidget(0, 1, panForm2);
		  
		  fcf.setColSpan(1, 0, 2);
		  HPanel panForm3 = new HPanel(408, 150, "header3"){
			  @Override
			  public HPanel setContent(){
				  TextArea area = new TextArea(); 
				  area.setVisibleLines(5);
				  CheckBox enableArea = new CheckBox("enable Area");
				  enableArea.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
						@Override
						public void onValueChange(ValueChangeEvent<Boolean> event) {
							area.setEnabled(event.getValue());
						}
					  });
				  enableArea.setValue(true, true);
				  
				  FlexTable layout = new FlexTable();
				  layout.setWidget(0, 0, enableArea);
				  layout.setWidget(1, 0, area);
				  layout.setCellPadding(2);
				  setContentWidget(layout);
				  return this;
			  }
		  }.setContent();
//		  panForm3.setContent();
		  ft.setWidget(1, 0, panForm3); 
		  ft.setStyleName("padding1px");
		  initWidget(ft);
	}

}
