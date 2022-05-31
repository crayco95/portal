/*
 * MIT License 
 * 
 * Copyright (c) 2018 Ownk
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 */
package com.portal.persistence.handler;


import org.ektorp.impl.StdObjectMapperFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author (Ownk) 
 * @version 1.0
 *
 * <h1>BaseTypeHandler</h1>
 */

public class BaseTypeHandler {
	
	public static final ObjectMapper mapper = new StdObjectMapperFactory().createObjectMapper();
	
}
