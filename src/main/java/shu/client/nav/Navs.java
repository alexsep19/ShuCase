package shu.client.nav;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import shu.client.tools.TitlePan;
import shu.client.startpoint;
import shu.client.comps.PasswordTxtBox;
import shu.client.comps.TxtBox;
import shu.client.nav.Navs.Images;
import shu.client.panForm.FormContent;
import shu.client.panForm.PanForm;

public class Navs extends Composite{
	SimpleLayoutPanel _center;
	TitlePan panForm, panTab;
	  /**
	   * Specifies the images that will be bundled for this Composite and specify
	   * that tree's images should also be included in the same bundle.
	   */
	  public interface Images extends Tree.Resources {
		@Source("../pic/drafts.png") 
	    ImageResource drafts();

	    @Source("../pic/home.png")
	    ImageResource home();

	    @Source("../pic/inbox.png")
	    ImageResource inbox();

	    @Source("../pic/sent.png")
	    ImageResource sent();
	    
	    @Source("../pic/templates.png")
	    ImageResource templates();

	    @Source("../pic/trash.png")
	    ImageResource trash();

	    @Override
	    @Source("../pic/noimage.png")
	    ImageResource treeLeaf();
	  }

	  private Tree tree;
	  /**
	   * Constructs a new mailboxes widget.
	   */
	  public Navs(SimpleLayoutPanel center) {
//		final Logger rootLogger = Logger.getLogger("");
//		rootLogger.log(Level.INFO, "DDDDDDDDDDFFFF");
		_center = center;
	    Images images = GWT.create(Images.class);

	    tree = new Tree(images);
	    tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
	        @Override
	        public void onSelection(SelectionEvent<TreeItem> event) {               
	            TreeItemAdv item = (TreeItemAdv) event.getSelectedItem();
	            if (item != null) item.doSelectionAction();
	        }
	    });
	    TreeItem root = new TreeItem(imageItemHTML(images.home(), "foo@example.com"));
	    TreeItem root2 = new TreeItem(imageItemHTML(images.home(), "Панели"));
	    tree.addItem(root);
	    tree.addItem(root2);

	    addImageItem(root, "Inbox", images.inbox(), new TreeItemAdv());
	    addImageItem(root, "Drafts", images.drafts(), new TreeItemAdv());
	    addImageItem(root, "Templates", images.templates(), new TreeItemAdv());
	    addImageItem(root, "Sent", images.sent(), new TreeItemAdv());
	    addImageItem(root, "Trash", images.trash(), new TreeItemAdv());

	    addImageItem(root2, "panForm", images.inbox(), new TreeItemAdv(){
	    			@Override
	    			protected void doSelectionAction() {
	    				showPanel(getPanForm());
//	    				rootLogger.log(Level.INFO, "doSelectionAction() ");
	    }});
	    addImageItem(root2, "panTab", images.inbox(), new TreeItemAdv(){
			@Override
			protected void doSelectionAction() {
				showPanel(getPanTab());
//				rootLogger.log(Level.INFO, "doSelectionAction() ");
        }});
	    root2.setState(true);
	    root2.getChild(0).setSelected(true);
	    
	    initWidget(tree);
	    showPanel(getPanForm());
	  }

	  TitlePan getPanForm(){
		  if (panForm == null){
			  panForm = new TitlePan("Форма");
			  FlexTable ft = new FlexTable();
			  FlexCellFormatter fcf = ft.getFlexCellFormatter();
			  ft.setCellPadding(2);
//			  ft.setCellSpacing(2);
			  ft.setWidget(0, 0, new PanForm(200, 150, "header1"){
				  public Widget setContent(){
					  TxtBox tbSurname = new TxtBox();
					  tbSurname.setWidth("100px");
					  tbSurname.setMaxLength(30);
					  tbSurname.setPlaceHolder("placeholder");
					  TxtBox tbName = new TxtBox();
					  tbName.setWidth("100px");
					  tbName.setMaxLength(30);
					  tbName.setPlaceHolder("tbName");
					  tbName.setValue("value");
					  CheckBox turnField = new CheckBox("Вкл/Выкл Field");
					  turnField.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
							@Override
							public void onValueChange(ValueChangeEvent<Boolean> event) {
								tbName.setEnabled(event.getValue());
							}
						  });
					  turnField.setValue(true, true);
					  CheckBox turnCheck = new CheckBox("Вкл/Выкл ChkBox");
					  turnCheck.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
						@Override
						public void onValueChange(ValueChangeEvent<Boolean> event) {
							turnField.setEnabled(event.getValue());
						}
					  });
					  turnCheck.setValue(true, true);

					  FlexTable layout = new FlexTable();
//					  FlexCellFormatter layoutFormat = layout.getFlexCellFormatter();
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
			  	}.setContent());
			  ft.setWidget(0, 1, new PanForm(200, 150, "header2"){
				  public Widget setContent(){
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
//					  datebox.setsetMaxLength(10);
					  
					  CheckBox maskField = new CheckBox("show text");
					  maskField.addValueChangeHandler(new ValueChangeHandler<Boolean>(){
							@Override
							public void onValueChange(ValueChangeEvent<Boolean> event) {
								tbPass.setMask(!event.getValue());
							}
						  });
					  maskField.setValue(false, true);
					  
					  FlexTable layout = new FlexTable();
					  layout.setCellPadding(2);
					  layout.setHTML(0, 0, "password");
					  layout.setWidget(0, 1, tbPass);
					  layout.setWidget(1, 1, maskField);
					  layout.setHTML(2, 0, "dropbox");
					  layout.setWidget(2, 1, dropBox);
					  layout.setHTML(3, 0, "date");
					  layout.setWidget(3, 1, datebox);
                      setContentWidget(layout);
					  return this;
				  }
			  }.setContent());
			  fcf.setColSpan(1, 0, 2);
			  ft.setWidget(1, 0, new PanForm(408, 150, "header3"){
				  public Widget setContent(){
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
			  }.setContent());
			  ft.setStyleName("padding1px");
			  panForm.addBody(ft);
		  }
		  return panForm;
	  }
	  
	  TitlePan getPanTab(){
		  if (panTab == null){
			  panTab = new TitlePan("Таблица");
			  panTab.addBody(new HTMLPanel("Фjjjjjjjjjj Таблица"));
		  }
		  return panTab;
	  }
	  
	  /**
	   * A helper method to simplify adding tree items that have attached images.
	   * {@link #addImageItem(TreeItem, String, ImageResource) code}
	   * 
	   * @param root the tree item to which the new item will be added.
	   * @param title the text associated with this item.
	   */
	  private TreeItem addImageItem(TreeItem root, String title, ImageResource imageProto, TreeItemAdv item) {
//	    TreeItemAdv item = new TreeItemAdv(imageItemHTML(imageProto, title)){
//	    	@Override
//	        protected void doSelectionAction() {
//	            // TODO: Do some stuff.
//	            System.out.println("1: Here I am.");
//	        }       
//	    };
		item.setHTML(imageItemHTML(imageProto, title));
	    root.addItem(item);
	    return item;
	  }

	  /**
	   * Generates HTML for a tree item with an attached icon.
	   * 
	   * @param imageProto the image prototype to use
	   * @param title the title of the item
	   * @return the resultant HTML
	   */
	  private SafeHtml imageItemHTML(ImageResource imageProto, String title) {
	    SafeHtmlBuilder builder = new SafeHtmlBuilder();
	    builder.append(AbstractImagePrototype.create(imageProto).getSafeHtml());
	    builder.appendHtmlConstant(" ");
	    builder.appendEscaped(title);
	    return builder.toSafeHtml();
	  }
	  
	  void showPanel(TitlePan pan){
		  _center.clear();
		  _center.add(pan);
	  }
}
