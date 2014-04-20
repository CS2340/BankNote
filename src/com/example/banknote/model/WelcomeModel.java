package com.example.banknote.model;

import iModel.iWelcomeModel;

public class WelcomeModel implements iWelcomeModel 
{
	@Override
	public void setUpDB(String path) 
	{
		DB.getInstance().setDB(path);
	}
}
