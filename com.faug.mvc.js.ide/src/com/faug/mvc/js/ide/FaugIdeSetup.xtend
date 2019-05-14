/*
 * generated by Xtext 2.17.1
 */
package com.faug.mvc.js.ide

import com.faug.mvc.js.FaugRuntimeModule
import com.faug.mvc.js.FaugStandaloneSetup
import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class FaugIdeSetup extends FaugStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new FaugRuntimeModule, new FaugIdeModule))
	}
	
}
