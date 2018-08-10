package shu.client.panTab;

import java.util.List;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import shu.client.comps.Dialog1butt;
import shu.client.comps.HPanel;

public class TabContent extends Composite{
	ProvidesKey<Data3field> providesKey = new ProvidesKey<Data3field>(){
		@Override
	      public Object getKey(Data3field item) {
	        return item == null ? null : item.getId();
	      }
	};
	Data3field data3field = new Data3field();
//	ListDataProvider<Data3field> _dataProvider = new ListDataProvider<Data3field>(){
	AsyncDataProvider<Data3field> dataProvider = new AsyncDataProvider<Data3field>(){
		@Override
		protected void onRangeChanged(HasData<Data3field> display) {
			int start = display.getVisibleRange().getStart();
			int end = start + display.getVisibleRange().getLength();
			List<Data3field> sub = data3field.getDataList().subList(start, end);
		    dataGrid.setRowData(start, sub);
			updateRowData(start, sub);
		};
	};
	DataGrid<Data3field> dataGrid;

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
		  
			data3field.initDataList();
			dataGrid = new DataGrid<Data3field>(providesKey);
		    dataGrid.setWidth("100%");
		    dataGrid.setAutoHeaderRefreshDisabled(true);
		    dataGrid.setEmptyTableWidget(new Label("Данных нет"));
		    
		    ListHandler<Data3field> sortHandler = null;
		    initTableColumns(sortHandler);
		    SelectionModel<Data3field> selectionModel = new SingleSelectionModel<Data3field>(providesKey);
//		    _dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<Data3field> DefaultSelectionEventManager());
		    dataGrid.setSelectionModel(selectionModel);
		    
		    dataGrid.setPageSize(5);
//		    _dataGrid.setRowCount(_data3field.getDataList().size(), true);
		    
		    dataProvider.addDataDisplay(dataGrid);
		    dataProvider.updateRowCount(data3field.getDataList().size(), true);
		    dataGrid.setHeight("300px");
		    dataGrid.setWidth("300px");
		    dataGrid.addDomHandler(new DoubleClickHandler(){
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					DataGrid<Data3field> grid = (DataGrid<Data3field>)event.getSource();
					int row = grid.getKeyboardSelectedRow();
					Dialog1butt dialog1butt = new Dialog1butt("ФФФФФФФФФФФ"){
					  @Override
					  protected Widget getDetails(){
						  FlexTable table = new FlexTable();
						  table.setCellPadding(2);
						  table.setHTML(0, 0, dataGrid.getVisibleItem(row).getName());
						  table.setHTML(1, 0, dataGrid.getVisibleItem(row).getSum().toString());
//						  table.setHTML(0, 0, _dataGrid.getVisibleItem(_dataGrid.getKeyboardSelectedRow()).getName());
//						  table.setHTML(1, 0, _dataGrid.getVisibleItem(_dataGrid.getKeyboardSelectedRow()).getSum().toString());
						  return table;
					  }
					};
					dialog1butt.center();
					dialog1butt.show();
					}
		    		}, DoubleClickEvent.getType());
		    dataGrid.addCellPreviewHandler(new CellPreviewEvent.Handler<Data3field>() {
				@Override
				public void onCellPreview(CellPreviewEvent<Data3field> event) {
					
					if (BrowserEvents.DBLCLICK.equalsIgnoreCase(event.getNativeEvent().getType())){
						Dialog1butt dialog1butt = new Dialog1butt("ФФФФФФФФФФФ"){
							  @Override
							  protected Widget getDetails(){
								  FlexTable table = new FlexTable();
								  table.setCellPadding(2);
								  table.setHTML(0, 0, dataGrid.getVisibleItem(event.getIndex()).getName());
								  table.setHTML(1, 0, dataGrid.getVisibleItem(event.getIndex()).getSum().toString());
								  return table;
							  }
						  };
						  dialog1butt.center();
						  dialog1butt.show();
					}
				}
			});
		    
		  ft.setWidget(0, 0, dataGrid);
		  ft.setStyleName("padding1px");
		  initWidget(ft);
	}

	private void initTableColumns(ListHandler<Data3field> sortHandler) {
		Column<Data3field, String> nameColumn = new Column<Data3field, String>(new TextCell()) {
	          @Override
	          public String getValue(Data3field object) {
	        	  return object.getName();
			  }
		};
		dataGrid.addColumn( nameColumn, "Наименование");
	    dataGrid.setColumnWidth(nameColumn, 20, Unit.PCT);
	    
		Column<Data3field, Number> sumColumn = new Column<Data3field, Number>(new NumberCell()) {
	          @Override
	          public Number getValue(Data3field object) {
	        	  return object.getSum();
			  }
		};
		sumColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		dataGrid.addColumn( sumColumn, "Сумма");
	    dataGrid.setColumnWidth(sumColumn, 20, Unit.PCT);

	}

}
