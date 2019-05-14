/*
 * Copyright (c) 2012 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.faug.mvc.js;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

/**
 * Class that provides services (e.g. validation, content description, encoding) to "MyDsl" files.
 *
 * @see org.eclipse.xtext.resource.IResourceServiceProvider
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
public class FaugjsResourceServiceProvider extends DefaultResourceServiceProvider {

  /**
   * Indicates that this service provider can only handle URIs that refers to a "MyDsl" file.
   * @param uri the URI to check. It may be {@code null}.
   * @return {@code true} if the given URI refers to a "MyDsl" file; {@code false} otherwise.
   */
  @Override public boolean canHandle(URI uri) {
    return isSource(uri) && FaugjsContentHandler.isMyDslFile(uri);
  }
}
