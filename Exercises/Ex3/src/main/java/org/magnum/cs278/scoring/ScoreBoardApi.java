package org.magnum.cs278.scoring;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;

public interface ScoreBoardApi {

	public static final String ASGN_PATH_PARAM = "asgn";
	public static final String STUDENT_PATH_PARAM = "student";
	public static final String STEP_PARAM = "step";
	public static final String STEP_PATH_PARAM = STEP_PARAM;
	public static final String STUDENT_COMPLETED_PATH = "/asgn/in-class-1/student/{student}/completed";
	
	@FormUrlEncoded
	@POST(STUDENT_COMPLETED_PATH)
	public String completed(
			@Path(STUDENT_PATH_PARAM) String student,
			@Field(STEP_PARAM) int step);
	
}
