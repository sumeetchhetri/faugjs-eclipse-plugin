package com.faug.mvc.js;

import static org.eclipse.emf.ecore.resource.ContentHandler.Validity.VALID;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.PlatformContentHandlerImpl;

public class FaugjsContentHandler extends PlatformContentHandlerImpl {

	public static final String COM_FAUG_JS_JSON = "com.faug.js.Json";

	public static boolean isFaugJsFile(URI uri) {
		if (uri == null || uri.isArchive())
			return false;
		String fileName = uri.lastSegment();
		// System.out.println(fileName);
		return fileName.startsWith("fjs-config") && fileName.endsWith(".json");
	}

	@Override
	public boolean canHandle(URI uri) {
		return isFaugJsFile(uri);
	}

	@Override
	public Map<String, Object> contentDescription(URI uri, InputStream inputStream, Map<?, ?> options,
			Map<Object, Object> context) throws IOException {
		Map<String, Object> description = super.contentDescription(uri, inputStream, options, context);
		if (canHandle(uri)) {
			description.put(VALIDITY_PROPERTY, VALID);
			description.put(CONTENT_TYPE_PROPERTY, COM_FAUG_JS_JSON);
		}
		return description;
	}
}
