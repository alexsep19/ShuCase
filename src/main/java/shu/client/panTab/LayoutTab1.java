package shu.client.panTab;

import java.util.List;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

public class LayoutTab1 extends Composite{
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
	
	//CwDataGrid
	public LayoutTab1() {
		_data3field.initDataList();
		_dataGrid = new DataGrid<Data3field>(_providesKey);
	    _dataGrid.setWidth("100%");
	    _dataGrid.setAutoHeaderRefreshDisabled(true);
	    _dataGrid.setEmptyTableWidget(new Label("Данных нет"));
	    
	    ListHandler<Data3field> sortHandler = null;
	    initTableColumns(sortHandler);
//	    SelectionModel<Data3field> selectionModel = new MultiSelectionModel<Data3field>(_providesKey);
//	    _dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<Data3field> createCheckboxManager());
	    
//	    SelectionModel<Data3field> selectionModel = new SingleSelectionModel<Data3field>(_providesKey);
	    NoSelectionModel<Data3field> selectionModel = new NoSelectionModel<Data3field>(_providesKey);
//	    selectionModel.addSelectionChangeHandler(handler)
	    _dataGrid.setSelectionModel(selectionModel);
	    
	    _dataGrid.setPageSize(10);
	    _dataGrid.setRowCount(_data3field.getDataList().size(), true);
	    
	    _dataProvider.addDataDisplay(_dataGrid);
	    _dataProvider.updateRowCount(_data3field.getDataList().size(), true);
	    SimpleLayoutPanel slp = new SimpleLayoutPanel();
	    slp.add(_dataGrid);
	    initWidget(slp);
	}

	private void initTableColumns(ListHandler<Data3field> sortHandler) {
		Column<Data3field, String> nameColumn = new Column<Data3field, String>(null){
			@Override
			public String getValue(Data3field object) {
				return object.getName();
			}
		};
		_dataGrid.addColumn( nameColumn, "Наименование");
	    _dataGrid.setColumnWidth(nameColumn, 20, Unit.PCT);
	}
}
