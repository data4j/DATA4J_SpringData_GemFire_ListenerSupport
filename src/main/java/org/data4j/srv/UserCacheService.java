package org.data4j.srv;

import org.data4j.user.User;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;

/**
 * UserCacheService Class is implementation of IUserCacheService Interface.
 * 
 * @author data4j.org
 * @since 21 Sept 2013
 * @version 1.0.0
 *
 */
public class UserCacheService implements IUserCacheService {
	
	private Cache userCache;
	private static final String REGION_PATH = "root/userRegion";
	
	@Override
	public void addToUserCache(User user) {
		getUserRegion().put(user.getId(), user);
	}

	@Override
	public void removeFromUserCache(String id) {
		getUserRegion().remove(id);
	}
	
	@Override
	public void updateViaUserCache(User user) {
		getUserRegion().put(user.getId(), user);
	}
	
	@Override
	public Region<String, User> getUserRegion() {
		return getUserCache().getRegion(REGION_PATH);
	}

	@Override
	public Cache getUserCache() {
		return userCache;
	}

	public void setUserCache(Cache userCache) {
		this.userCache = userCache;
	}
	
}
