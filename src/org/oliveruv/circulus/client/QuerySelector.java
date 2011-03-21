package org.oliveruv.circulus.client;

import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.Selector;
import com.google.gwt.query.client.Selectors;

public interface QuerySelector extends Selectors {
	@Selector("#contentPane")
	GQuery getContentPane();
}
