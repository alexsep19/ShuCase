/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package shu.client.nav;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A tree displaying a set of email folders.
 */
public class Navs extends Composite {

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
  public Navs() {
	final Logger rootLogger = Logger.getLogger("");
//	rootLogger.log(Level.INFO, "DDDDDDDDDDFFFF");
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

    addImageItem(root2, "List no page", images.inbox(), new TreeItemAdv(){
    			@Override
    			protected void doSelectionAction() {
//    				rootLogger.log(Level.INFO, "doSelectionAction() ");
    }});
//    addImageItem(root2, "List with page", images.drafts());
    root2.setState(true);
    
    initWidget(tree);
  }

  /**
   * A helper method to simplify adding tree items that have attached images.
   * {@link #addImageItem(TreeItem, String, ImageResource) code}
   * 
   * @param root the tree item to which the new item will be added.
   * @param title the text associated with this item.
   */
  private TreeItem addImageItem(TreeItem root, String title, ImageResource imageProto, TreeItemAdv item) {
//    TreeItemAdv item = new TreeItemAdv(imageItemHTML(imageProto, title)){
//    	@Override
//        protected void doSelectionAction() {
//            // TODO: Do some stuff.
//            System.out.println("1: Here I am.");
//        }       
//    };
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
}
