package com.otv.srv;

import com.tangosol.net.NamedCache;

/**
 * IUserCacheService Interface exposes User Cache operations
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 *
 */
public interface IUserCacheService {

	/**
     * Adds user entries to cache
     *
     * @param Object key
     * @param Object value
     * 
     */
	void addToUserCache(Object key, Object value);
	
	/**
     * Deletes user entries from cache
     *
     * @param Object key
     * 
     */
	void deleteFromUserCache(Object key);
	
	/**
     * Gets user cache
     *
     * @retun NamedCache Coherence named cache
     */
	NamedCache getUserCache();
	
}
