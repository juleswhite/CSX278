package org.magnum.cs278.bootstrapex;

public class Student {

	// Change this to your full name as it appears in YES separated
	// by a comma with no spaces between the last name (Jones) and the first name (Bob):
	private final String name = "White,Jules";

	// By changing this variable to true, you agree to adhere to the honor code
	// and that you will only change the "in class" variable to true if you are
	// actually in class. You also agree, per the honor code, that you have
	// correctly set your name in the previous variable.
	private final boolean iUnderstandThatIAmBoundByTheHonorCode = true;

	// By changing this variable to true, you are stating per the honor code
	// that
	// you are currently in class and working on this assignment
        // and everyone in your group will vouch for you
	private final boolean iAmInClass = true;

	public String getName() {
		return name;
	}

	public boolean getIUnderstandThatIAmBoundByTheHonorCode() {
		return iUnderstandThatIAmBoundByTheHonorCode;
	}

	public boolean getIAmInClass() {
		return iAmInClass;
	}

}
