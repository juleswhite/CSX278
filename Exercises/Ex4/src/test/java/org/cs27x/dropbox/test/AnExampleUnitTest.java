package org.cs27x.dropbox.test;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;

import org.cs27x.dropbox.DefaultFileManager;
import org.cs27x.dropbox.Dropbox;
import org.cs27x.dropbox.DropboxProtocol;
import org.cs27x.filewatcher.DropboxFileEventHandler;
import org.cs27x.filewatcher.FileEvent;
import org.cs27x.filewatcher.FileStates;
import org.junit.Test;

/**
 * Please give your tests rational names that are related to what you are
 * testing!
 * 
 * @author jules
 * 
 */
public class AnExampleUnitTest {

	/**
	 * Helpful hints:
	 * 
	 * 1. JUnit provides a bunch of helpful assertion methods for checking
	 * conditions, such as:
	 * 
	 * assertNotNull(...) assertTrue(...) assertEquals(expected, actual)
	 * 
	 * You can import these assertions into a test by adding the following
	 * static import:
	 * 
	 * import static org.junit.Assert.*;
	 * 
	 * 2. Mockito provides a bunch of helpful methods for verifying calls to
	 * mock objects, such as:
	 * 
	 * verify(some_mock_obj,
	 * the_number_of_expected_calls).theMethodYouExpectedWasCalled(
	 * eq(the_value_you_wanted_for_param1), eq(the_value_you_wanted_for_param2)
	 * );
	 * 
	 * You can import these helpers with:
	 * 
	 * import static org.mockito.Mockito.*;
	 * 
	 * @throws Exception
	 */

	@Test
	public void aBadTest() throws Exception {
		// This is a really poor test
		Dropbox dropbox = new Dropbox(Paths.get("./"));
		// dropbox.connect(null);

		// Using a simple JUnit assertion
		assertNotNull(dropbox);
	}

	@Test
	public void aBadTestWithAMockObject() throws Exception {
		//Creating a mock object
		DropboxProtocol transport = mock(DropboxProtocol.class);
		
		// An example of stubbing a mock object to make it behave
		// like you want.
		when(transport.toString()).thenReturn("1234");
		
		// A simple test to prove that the stubbing above worked..
		// you don't need to test your stubs
		assertEquals("1234",transport.toString());
		
		// Real objects can't tell the difference between our mock object
		// and the real deal
		DropboxFileEventHandler hdlr = new DropboxFileEventHandler(
					new DefaultFileManager(Paths.get("test-data/working-dir")),
					new FileStates(),
					transport);
		
		Path p = Paths.get("some_test_path");
		FileEvent evt = new FileEvent(ENTRY_CREATE, p);
		hdlr.handle(evt);
		
		// Make sure that transport made a call to our mock object
		// like we expected
		verify(transport,times(1)).addFile(eq(p));
	}
}
