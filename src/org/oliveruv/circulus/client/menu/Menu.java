package org.oliveruv.circulus.client.menu;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class Menu extends Composite {
	interface MenuUiBinder extends UiBinder<Widget, Menu> {}
	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	
	@UiField MenuBar menuBar;
	@UiField MenuItem news;
	@UiField MenuItem bio;
	@UiField MenuItem discog;
	@UiField MenuItem live;
	@UiField MenuItem media;
	
	@UiField(provided = true)
	final BundledResources res;
	
	
	@Inject
	public Menu(BundledResources resources) {
		this.res = resources;
		initWidget(uiBinder.createAndBindUi(this));
		menuBar.insertSeparator(menuBar.getItemIndex(media));
		menuBar.insertSeparator(menuBar.getItemIndex(live));
		menuBar.insertSeparator(menuBar.getItemIndex(discog));
		menuBar.insertSeparator(menuBar.getItemIndex(bio));
	}
	
	public class MenuCommand implements Command {
		//final HistoryToken historyToken;
		public MenuCommand() {
			
		}

		@Override
		public void execute() {
			
		}
	}
}
