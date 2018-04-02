package shu.client.panTab;

import java.util.List;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ProvidesKey;

import shu.client.comps.HPanel;

public class TabContent extends Composite{
	ProvidesKey<Data3field> _providesKey = new ProvidesKey<Data3field>(){
		@Override
	      public Object getKey(Data3field item) {
	        return item == null ? null : item.getId();
	      }
	};
	Data3field _data3field = new Data3field();
//	ListDataProvider<Data3field> _dataProvider = new ListDataProvider<Data3field>(){
	AsyncDataProvider<Data3field> _dataProvider = new AsyncDataProvider<Data3field>(){
		@Override
		protected void onRangeChanged(HasData<Data3field> display) {
			int start = display.getVisibleRange().getStart();
			int end = start + display.getVisibleRange().getLength();
			List<Data3field> sub = _data3field.getDataList().subList(start, end);
		    _dataGrid.setRowData(start, sub);
			updateRowData(start, sub);
		};
	};
	DataGrid<Data3field> _dataGrid;

	public TabContent() {
		  FlexTable ft = new FlexTable();
		  FlexCellFormatter fcf = ft.getFlexCellFormatter();
		  ft.setCellPadding(2);
//		  HPanel panTab1 = new HPanel(400, 250, "panTab1"){
//			  @Override
//			  public HPanel setContent(){
//				  setContentWidget(new LayoutTab1());
//				  return this;
//			  }
//		  }.setContent();
//
//		  ft.setWidget(0, 0, panTab1); 
//
//		  HPanel panTab2 = new HPanel(400, 250, "panTab2"){
//			  @Override
//			  public HPanel setContent(){
////				  setContentWidget(layout);
//				  return this;
//			  }
//		  }.setContent();
//		  ft.setWidget(0, 1, panTab2);
		  
			_data3field.initDataList();
			_dataGrid = new DataGrid<Data3field>(_providesKey);
		    _dataGrid.setWidth("100%");
		    _dataGrid.setAutoHeaderRefreshDisabled(true);
		    _dataGrid.setEmptyTableWidget(new Label("Данных нет"));
		    
		    ListHandler<Data3field> sortHandler = null;
		    initTableColumns(sortHandler);
//		    SelectionModel<Data3field> selectionModel = new MultiSelectionModel<Data3field>(_providesKey);
//		    _dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<Data3field> createCheckboxManager());
		    
		    _dataGrid.setPageSize(10);
//		    _dataGrid.setRowCount(_data3field.getDataList().size());
		    
		    _dataProvider.addDataDisplay(_dataGrid);
		    _dataProvider.updateRowCount(_data3field.getDataList().size(), true);
//		    VerticalPanel slp = new VerticalPanel();
		    _dataGrid.setHeight("300px");
		    _dataGrid.setWidth("200px");
//		    slp.add(_dataGrid);

		  
		  ft.setWidget(0, 0, _dataGrid);
		  ft.setStyleName("padding1px");
		  initWidget(ft);
	}

	private void initTableColumns(ListHandler<Data3field> sortHandler) {
		Column<Data3field, String> nameColumn = new Column<Data3field, String>(new EditTextCell()) {
	          @Override
	          public String getValue(Data3field object) {
	        	  return object.getName();
			  }
		};
		_dataGrid.addColumn( nameColumn, "Наименование");
//		nameColumn.setFieldUpdater(new FieldUpdater<Data3field, String>() {
//			 @Override
//	         public void update(int index, Data3field object, String value) {
//	        // Called when the user changes the value.
//	             object.setName(value);
//	             _dataProvider.refresh();
//			 }
//	    });
	    _dataGrid.setColumnWidth(nameColumn, 20, Unit.PCT);
	}

}
