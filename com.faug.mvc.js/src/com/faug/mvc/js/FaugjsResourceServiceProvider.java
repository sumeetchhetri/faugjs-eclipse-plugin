package com.faug.mvc.js;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

public class FaugjsResourceServiceProvider extends DefaultResourceServiceProvider {

	@Override
	public boolean canHandle(URI uri) {
		return isSource(uri) && FaugjsContentHandler.isFaugJsFile(uri);
	}
}
