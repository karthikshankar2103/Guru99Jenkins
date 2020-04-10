package com.step.definision;

import com.utile.files.UtileClass;

import cucumber.api.java.After;

public class Hooks {
	@After
	public void close() {
		UtileClass.close();
	}

}
