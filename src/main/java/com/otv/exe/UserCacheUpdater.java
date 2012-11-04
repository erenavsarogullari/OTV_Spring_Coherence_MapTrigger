package com.otv.exe;

import java.util.Collection;

import org.apache.log4j.Logger;

import com.otv.srv.IUserCacheService;
import com.otv.user.User;

/**
 * CacheUpdater Class updates and prints user cache entries
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 *
 */
public class UserCacheUpdater implements Runnable {
	
	private static Logger logger = Logger.getLogger(UserCacheUpdater.class);
	
	private IUserCacheService userCacheService;
	
	/**
     * Runs the UserCacheUpdater Thread
     *
     */
	public void run() {		
		
		//New User are created...
		User user = new User();
		
//		//Only Name and Surname properties are set and Id property will be set at trigger level. 
//		user.setName("James");
//		user.setSurname("Joyce");
//		
//		//Entries are added to cache...
//		getUserCacheService().addToUserCache("user1", user);

//		The following code block shows the entry which will be inserted via second member of the cluster 
//      so it should be opened and above code block should be commented-out before the project is built.
		
		user.setName("Thomas");
		user.setSurname("Moore");
		getUserCacheService().addToUserCache("user2", user);

		//Cache Entries are being printed...
		printCacheEntries();		
	}
	
	/**
     * Prints User Cache Entries
     *
     */
	@SuppressWarnings("unchecked")
	private void printCacheEntries() {
		Collection<User> userCollection = null;
		try {
			while(true) {
				userCollection = (Collection<User>)getUserCacheService().getUserCache().values();
				
				for(User user : userCollection) {
					logger.debug("Cache Content : " + user);
				}
				
				Thread.sleep(60000);			
			}
		} catch (InterruptedException e) {
			logger.error("CacheUpdater is interrupted!", e);
		}
	}

	public IUserCacheService getUserCacheService() {
		return userCacheService;
	}

	public void setUserCacheService(IUserCacheService userCacheService) {
		this.userCacheService = userCacheService;
	}	
}
