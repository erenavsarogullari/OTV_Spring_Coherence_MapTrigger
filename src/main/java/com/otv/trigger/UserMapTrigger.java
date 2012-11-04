package com.otv.trigger;

import org.apache.log4j.Logger;

import com.otv.listener.UserMapListener;
import com.otv.user.User;
import com.tangosol.util.MapTrigger;

/**
 * UserMapTrigger executes required logic before the operation is committed
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 * 
 */
public class UserMapTrigger implements MapTrigger {
	
	private static final long serialVersionUID = 5411263646665358790L;
	private static Logger logger = Logger.getLogger(UserMapListener.class);
	
	/**
     * Processes user cache entries
     *
     * @param MapTrigger.Entry entry
     * 
     */
	public void process(MapTrigger.Entry entry) {
		User user = (User) entry.getValue();
		String id = user.getId();
		String name = user.getName();
		String updatedName = name.toUpperCase();

		String surname = user.getSurname();
		String updatedSurname = surname.toUpperCase();

		if (!updatedName.equals(name)) {
			user.setName(updatedName);
		}
		
		if (!updatedSurname.equals(surname)) {
			user.setSurname(updatedSurname);
		}
		
		user.setId(user.getName() + "_" + user.getSurname());
		
		entry.setValue(user);
		
		logger.debug("UserMapTrigger processes the entry before committing. "
							+ "oldId : " + id 
	            			+ ", newId : " + ((User)entry.getValue()).getId() 
		                    + ", oldName : " + name 
				            + ", newName : " + ((User)entry.getValue()).getName() 
				            + ", oldSurname : " + surname 
				            + ", newSurname : " + ((User)entry.getValue()).getSurname()
				            );				
	}
	
	public boolean equals(Object o) {
		return o != null && o.getClass() == this.getClass();
	}

	public int hashCode() {
		return getClass().getName().hashCode();
	}

}
