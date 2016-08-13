package org.magnum.cs278.bootstrapex.json;

import org.magnum.cs278.bootstrapex.Function;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToString implements Function {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@Override
	public Object apply(Object[] args) {
		try{
			return OBJECT_MAPPER.writeValueAsString(args[0]);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
