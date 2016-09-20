package org.magnum.cs278.testdriven;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A simple application that pull special event permits for the Nashville parks
 * and displays 3 of them. The way it displays the permits isn't very helpful.
 * 
 * @author jules
 *
 */
public class App {

	// This is a JSON feed of the park special permits
	private static final String PARK_SPECIAL_PERMITS = "http://data.nashville.gov/resource/vygj-v677.json";

	// An ObjectMapper turns JSON into Java Objects (e.g., Event instances)
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final JavaType eventListType = objectMapper.getTypeFactory()
			.constructCollectionType(List.class, Event.class);

	/**
	 * The entry point to Java applications is a "main" method with the exact
	 * signature shown below.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		App app = new App();
		List<Event> evts = app.getThreeThingsToDo();
		for (Event e : evts) {
			System.out.println(e);
		}
	}

	// Download the list of special event park permits and select
	// the first three permits that are in the future
	public List<Event> getThreeThingsToDo() throws Exception {
		List<Event> toDo = new ArrayList<Event>();
		List<Event> evts = getParkSpecialPermits();

		DateTime now = DateTime.now();
		for (Event evt : evts) {
			if (evt.getDateTime().isAfter(now)) {
				toDo.add(evt);
				if (toDo.size() >= 3) {
					break;
				}
			}
		}
		
		// If we were using Java 8, we could replace this method with this
		// one-liner:
		//
		//return evts.stream()
		//			.filter(e -> e.getDateTime().isAfter(DateTime.now()))
		//          .limit(3)
		//			.collect(Collectors.toList());

		return toDo;
	}

	// Download a list of all special event park permits for Nashville.
	public List<Event> getParkSpecialPermits() throws Exception {
		
		// Read the JSON from the provided URL and turn it into
		// a list of Event object instances. The ObjectMapper automatically
		// sets the member variable values on the instances by mapping
		// JSON fields to the corresponding "setX" methods in the target
		// class. For example, "location" is set on the target object
		// by calling "setLocation( value )" with the value of the JSON
		// field.
		return objectMapper.readValue(new URL(
				PARK_SPECIAL_PERMITS),
				eventListType
				);
	}
}
