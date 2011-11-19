package org.oliveruv.circulus.client;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.allen_sauer.gwt.log.client.Log;

public class LoggingExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void onUncaughtException(Throwable e) {
		Log.debug(e.getLocalizedMessage());
		Log.debug(e.getMessage());
		Log.debug("Error caught by logging handler: ", e);
	}

}