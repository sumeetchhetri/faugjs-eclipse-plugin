package com.faug.mvc.js;

import static org.eclipse.emf.ecore.resource.ContentHandler.Validity.VALID;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.PlatformContentHandlerImpl;

public class FaugjsContentHandler extends PlatformContentHandlerImpl {
	
	private static final Set<String> faugFiles = new HashSet<>();
	
	public static void addFaugFile(String file) {
		faugFiles.add(file);
	}
	
	public static final String COM_FAUG_JS_JSON = "com.faug.js.Json";

	public static boolean isMyDslFile(URI uri) {
		if (uri == null || uri.isArchive())
			return false;
		String fileName = uri.lastSegment();
		//System.out.println(fileName);
		return fileName.startsWith("fjs-config") && fileName.endsWith(".json");
	}

	/**
	 * Indicates that this content handler can only handle URIs that belong to a
	 * "MyDsl" files.
	 * 
	 * @param uri the URI to check. It may be {@code null}.
	 * @return {@code true} if the given URI belongs to a "MyDsl" file;
	 *         {@code false} otherwise.
	 */
	@Override
	public boolean canHandle(URI uri) {
		return isMyDslFile(uri);
	}

	/**
	 * Returns a map of properties that describe the content of the given URI's
	 * corresponding input stream. If the given URI refers to a "MyDsl" file, this
	 * method will mark the contents as valid and it will assign the content type
	 * appropiately.
	 * 
	 * @param uri         the URI for which to determine the content description.
	 * @param inputStream the {@code InputStream} associated with the given URI.
	 * @param options     direct what kind of description is needed.
	 * @param context     contextual information that content handlers use to store
	 *                    partially computed results.
	 * @return a map of properties that describe the content of the given URI's
	 *         corresponding input stream.
	 * @throws IOException if there is a problem reading the stream.
	 */
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
