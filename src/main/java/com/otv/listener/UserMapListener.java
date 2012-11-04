package com.otv.listener;

import org.apache.log4j.Logger;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

/**
 * UserMapListener Class listens user cache events
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 *
 */
public class UserMapListener implements MapListener {

	private static Logger logger = Logger.getLogger(UserMapListener.class);
	
	public void entryDeleted(MapEvent me) {
		logger.debug("Deleted Key = " + me.getKey() + ", Value = " + me.getOldValue());
	}

	public void entryInserted(MapEvent me) {
		logger.debug("Inserted Key = " + me.getKey() + ", Value = " + me.getNewValue());
	}

	public void entryUpdated(MapEvent me) {
//		logger.debug("Updated Key = " + me.getKey() + ", New_Value = " + me.getNewValue() + ", Old Value = " + me.getOldValue());
	}	
}
