package org.data4j.exe;

import org.data4j.srv.IUserCacheService;
import org.data4j.srv.UserCacheService;
import org.data4j.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class starts the application
 * 
 * @author data4j.org
 * @since 21 Sept 2013
 * @version 1.0.0
 *
 */
public class Application {

	/**
     * Starts the application
     *
     * @param  String[] args
     *
     */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserCacheService userCacheService =  context.getBean(UserCacheService.class);
		
		User firstUser = new User();
		firstUser.setId("1");
		firstUser.setName("Bruce");
		firstUser.setSurname("Willis");
		
		User secondUser = new User();
		secondUser.setId("2");
		secondUser.setName("Russell");
		secondUser.setSurname("Crowe");
		
		User otherSecondUser = new User();
		otherSecondUser.setId("2");
		otherSecondUser.setName("Denzel");
		otherSecondUser.setSurname("Washington");
		
		//afterCreate
		userCacheService.addToUserCache(firstUser);
		
		userCacheService.addToUserCache(secondUser);
					
		//afterUpdate
		userCacheService.updateViaUserCache(otherSecondUser);
		
		//afterDestroy
		userCacheService.removeFromUserCache(firstUser.getId());
		
		//afterInvalidate
		userCacheService.getUserRegion().invalidate(secondUser.getId());
		
		//afterRegionInvalidate
		userCacheService.getUserRegion().invalidateRegion();
		
		//afterRegionClear
		userCacheService.getUserRegion().clear();
		
		//afterRegionDestroy
		userCacheService.getUserRegion().destroyRegion();
		
		//close
		userCacheService.getUserCache().close();
		
	}
}
