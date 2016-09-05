package org.magnum.cs278.bootstrapex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.magnum.cs278.bootstrapex.ReflectionUtils.on;
import static org.magnum.cs278.bootstrapex.ReflectionUtils.wrap;

import java.util.UUID;

import org.junit.Test;

public class BootstrapTest {
	
	@Test
	public void testStep0() {
		Student student = new Student();
		assertTrue(!student.getName().equals("Your Last Name,Your First Name"));
		assertTrue(student.getName().trim().length() > 5);
		assertTrue(student.getIAmInClass());
		assertTrue(student.getIUnderstandThatIAmBoundByTheHonorCode());
		
	}

	@Test
	public void testStep1(){
		// By running this test, you have pulled off step 2!
		assertTrue(true);
		
	}
	
	@Test
	public void testStep2() throws Exception {
		Class<?> c = Class.forName("net.sf.cglib.proxy.Callback");
		assertNotNull(c);
		
	}
	
	@Test
	public void testStep3(){
		
		// Update me!
		Class<?> thrower = null;
		int line = -1;
		
		try{
			App.main(null);
		}catch(Exception e){
			// Programmatically check which class and line number
			// threw the exception
			StackTraceElement[] stack = e.getStackTrace();
			assertEquals(stack[0].getClassName(), thrower.getName());
			assertEquals(stack[0].getLineNumber(), line);
		}
		
	}
	
	@Test 
	public void testStep4(){
		
		final String expected = UUID.randomUUID().toString();
		
		// Create a simple anonymous inner class that implements
		// 
		Function f = new Function() {
			
			@Override
			public Object apply(Object[] args) {
				assertEquals(BootstrapTest.this, args[0]);
				
				return expected;
			}
		};
		
		BootstrapTest obj = wrap(BootstrapTest.class, this);
		on(obj).replaceMethod(obj.toString()).with(f);
		
		assertEquals(expected, obj.toString());
		
	}
}
