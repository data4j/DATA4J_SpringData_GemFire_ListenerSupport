package org.data4j.srv;

import org.data4j.user.User;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;

/**
 * IUserCacheService Interface exposes cache functionality.
 * 
 * @author data4j.org
 * @since 21 Sept 2013
 * @version 1.0.0
 *
 */
public interface IUserCacheService {

	/**
     * Adds Customer entry to cache
     *
     * @param User value 
     *
     */
	void addToUserCache(User user);
	
	/**
     * Removes User entry from cache
     *
     * @param String key
     *
     */
	void removeFromUserCache(String id);
	
	/**
     * Updates User entry via cache
     *
     * @param User value
     *
     */
	void updateViaUserCache(User user);
	
	/**
     * Gets User Region
     *
     * @return Region<String,User> User-Region
     */
	Region<String, User> getUserRegion();
	
	/**
     * Gets User cache
     *
     * @return Cache User-Cache
     */
	Cache getUserCache();
	
}
