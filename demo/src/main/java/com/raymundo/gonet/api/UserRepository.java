package com.raymundo.gonet.api;

import com.raymundo.gonet.model.RaymundoGonetOmbdUser;

public interface UserRepository{
	
	public RaymundoGonetOmbdUser findByUsername(String username);
}