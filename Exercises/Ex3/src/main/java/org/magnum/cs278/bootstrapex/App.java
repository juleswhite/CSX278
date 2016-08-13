package org.magnum.cs278.bootstrapex;

import static org.magnum.cs278.bootstrapex.ReflectionUtils.*;

import org.magnum.cs278.bootstrapex.json.JsonToString;

/**
 * A simple application that demonstrates using Java dynamic Proxy objects and
 * reflection to swap out the implementation of one method on an object at runtime.
 * 
 * @author jules
 *
 */
public class App {

	/**
	 * The entry point to Java applications is a "main" method with the exact
	 * signature shown below.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		// Run our handy dandy method replacer to swap out this
		// class' toString() method with another implementation
		// at runtime. If you are an advanced Java programmer and
		// want to know how this works, after finishing the assignment,
		// you can look at the CglibProxyCreator and ReflectionUtils classes
		Student student = wrap(Student.class, new Student());
		on(student).replaceMethod(student.toString()).with(new JsonToString());
		
		// This method should print out a representation of the Student object
		// as a JSON string
		System.out.println(student.toString());
	}
}
