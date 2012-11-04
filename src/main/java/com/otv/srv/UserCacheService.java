package com.otv.srv;

import com.otv.listener.UserMapListener;
import com.otv.trigger.UserMapTrigger;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.MapTriggerListener;

/**
 * CacheService Class implements the ICacheService
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 *
 */
public class UserCacheService implements IUserCacheService {
	
	private NamedCache userCache = null;	
	private static final String USER_MAP = "user-map";
	private static final long   LOCK_TIMEOUT = -1;
	
	public UserCacheService() {
		setUserCache(CacheFactory.getCache(USER_MAP));
		getUserCache().addMapListener(new UserMapListener());		
		getUserCache().addMapListener(new MapTriggerListener(new UserMapTrigger())); 
	}	
	
	/**
     * Adds user entries to cache
     *
     * @param Object key
     * @param Object value
     * 
     */
	public void addToUserCache(Object key, Object value) {
		// key is locked
		getUserCache().lock(key, LOCK_TIMEOUT);
		try {
			// application logic
			getUserCache().put(key, value);
		} finally {
			// key is unlocked
			getUserCache().unlock(key);
		}
	}

	/**
     * Deletes user entries from cache
     *
     * @param Object key
     * 
     */
	public void deleteFromUserCache(Object key) {
		// key is locked
		getUserCache().lock(key, LOCK_TIMEOUT);
		try {
			// application logic
			getUserCache().remove(key);
		} finally {
			// key is unlocked
			getUserCache().unlock(key);
		}
	}

	/**
     * Gets user cache
     *
     * @retun NamedCache Coherence named cache
     */
	public NamedCache getUserCache() {
		return userCache;
	}

	public void setUserCache(NamedCache userCache) {
		this.userCache = userCache;
	}
			
}
