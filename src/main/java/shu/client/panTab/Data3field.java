package shu.client.panTab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data3field {
	int _id;

	String _name;
	Double _sum;
    Date _date;
    List<Data3field> _dataList = new ArrayList<Data3field>();
	
	public Data3field() {
	}
	public Data3field(int id, String name, Double sum, Date date) {
		_name = name;
		_sum = sum;
		_date = date;
	}

	public void initDataList(){
		for(int i = 0; i < 100; i++)
		_dataList.add(new Data3field(i, "ddddddddd"+i, new Double(i/10), new Date()));
	}
	
    public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public Double getSum() {
		return _sum;
	}

	public void setSum(Double sum) {
		this._sum = sum;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		this._date = date;
	}

	public List<Data3field> getDataList() {
		return _dataList;
	}

	public void setDataList(List<Data3field> dataList) {
		this._dataList = dataList;
	}

    public int getId() {
		return _id;
	}
	public void setId(int _id) {
		this._id = _id;
	}
}
