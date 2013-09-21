package org.data4j.listener;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.data4j.user.User;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.RegionEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

/**
 * 
 * UserCacheListener Class listens the changes made on the cache
 * 
 * @author data4j.org
 * @since 21 Sept 2013
 * @version 1.0.0
 *
 */
public class UserCacheListener extends CacheListenerAdapter<String, User> implements Declarable {
	
	private static Logger log = Logger.getLogger(UserCacheListener.class);
	
	/**
     * Handles the event of new key being added to a region.
     * 
     * @param EntryEvent<String, User> event 
     */
	@Override
	public void afterCreate(EntryEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		String key = event.getKey();
		User newValue = event.getNewValue();
		log.info("afterCreate - RegionName : " + regionName + ", CreatedKey : " + key
				+ ", CreatedValue : " + newValue);
	}

	/**
     * Handles the event of an entry being destroyed.
     * 
     * @param EntryEvent<String, User> event 
     */
	@Override
	public void afterDestroy(EntryEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		String key = event.getKey();
		log.info("afterDestroy - RegionName : " + regionName + ", DestroyedKey : " + key);
	}
	
	/**
     * Handles the event of an entry's value being modified in a region.
     * 
     * @param EntryEvent<String, User> event 
     */
	@Override
	public void afterUpdate(EntryEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		String key = event.getKey();
		User newValue = event.getNewValue();
		User oldValue = event.getOldValue();
		log.info("afterUpdate - RegionName : " + regionName + ", UpdatedKey : " + key
				+ ", OldValue : " + oldValue + ", NewValue : " + newValue);
	}
	
	/**
     * Handles the event of an entry's value being invalidated.
     * 
     * @param EntryEvent<String, User> event 
     */
	@Override
	public void afterInvalidate(EntryEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		String key = event.getKey();
		User newValue = event.getNewValue();
		User oldValue = event.getOldValue();
		log.info("afterInvalidate - RegionName : " + regionName + ", InvalidatedKey : " + key
				+ ", OldValue : " + oldValue + ", NewValue : " + newValue);
	}
	
	/**
     * Handles the event of a region being cleared.
     * 
     * @param RegionEvent<String, User> event 
     */
	@Override
	public void afterRegionClear(RegionEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		log.info("afterRegionClear - Cleared RegionName : " + regionName);
	}
	
	/**
     * Handles the event of a region being created.
     * 
     * @param RegionEvent<String, User> event 
     */
	@Override
	public void afterRegionCreate(RegionEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		log.info("afterRegionCreate - Created RegionName : " + regionName);
	}
	
	/**
     * Handles the event of a region being destroyed.
     * 
     * @param RegionEvent<String, User> event 
     */
	@Override
	public void afterRegionDestroy(RegionEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		log.info("afterRegionDestroy - Destroyed RegionName : " + regionName);
	}
	
	/**
     * Handles the event of a region being invalidated.
     * 
     * @param RegionEvent<String, User> event 
     */
	@Override
	public void afterRegionInvalidate(RegionEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		log.info("afterRegionInvalidate - Invalidated RegionName : " + regionName);
	}
	
	/**
     * Handles the event of a region being live after receiving the marker from the server.
     * 
     * @param RegionEvent<String, User> event 
     */
	@Override
	public void afterRegionLive(RegionEvent<String, User> event) {
		String regionName = event.getRegion().getName();
		log.info("afterRegionLive - RegionLive RegionName : " + regionName);
	}

	/**
     * Called when the region containing this callback is closed or destroyed, 
     * when the cache is closed, or when a callback is removed from a region 
     * using an AttributesMutator.
     */
	@Override
	public void close() {
		log.info("Cache is closed!!!");
	}

	@Override
	public void init(Properties arg0) {
		// do nothing
	}

}
