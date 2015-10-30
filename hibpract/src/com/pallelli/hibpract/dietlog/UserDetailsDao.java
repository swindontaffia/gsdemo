package com.pallelli.hibpract.dietlog;

import com.pallelli.hibpract.dietlog.beans.UserDetails;

public interface UserDetailsDao {
	
	UserDetails getUserDetails(String userName); 
}
