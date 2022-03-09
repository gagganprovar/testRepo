package customapis;


import java.io.File;
import java.util.logging.Logger;
import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Delete File"
, summary=""
, remarks=""
, iconBase=""
, defaultApiGroups={"Custom"}
		)
@TestApiParameterGroups(parameterGroups={
		@TestApiParameterGroup(groupName="inputs", title="Inputs"),
		@TestApiParameterGroup(groupName="result", title="Result"),
})
public class DeleteFile {

	@TestApiParameter(seq=1, 
			summary="The first parameter's summary.",
			remarks="",
			mandatory=true,
			parameterGroup="inputs")
	public String fileName;

	@TestApiParameter(seq=10, 
			summary="The name that the result will be stored under.",
			remarks="",
			mandatory=true,
			parameterGroup="result")
	public String resultName;

	@TestApiParameter(seq=11, 
			summary="The lifespan of the result.",
			remarks="",
			mandatory=true,
			parameterGroup="result",
			defaultValue="Test")
	public ValueScope resultScope;

	/** 
	 * Used to write to the test execution log.
	 */
	@TestLogger
	public Logger testLogger;

	/** 
	 * Provides access to facilities, mainly to set and get variable values.
	 */
	@TestExecutionContext
	public ITestExecutionContext testExecutionContext;

	@TestApiExecutor
	public void execute() {

		// Put our implementation logic here.
		testLogger.info("Running " + this.getClass().getName());
		String status = "File is not present"; 
		String currentDir=System.getProperty("user.home")+File.separator+ "Downloads";	
		testLogger.info(currentDir);

		File dir = new File(currentDir);
		File[] dirFileList =  dir.listFiles();


		for(int i=0;i<dirFileList.length;i++)
		{
			if(dirFileList[i].getName().equalsIgnoreCase(fileName))
			{
				dirFileList[i].delete();
				status="File is deleted";
				break;
			}
		}
		// Store the result (if appropriate).
		String dummyResult = this.getClass().getName() + " result";
		testExecutionContext.setValue(resultName, status, resultScope);
	}
}
