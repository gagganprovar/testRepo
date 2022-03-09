package customapis;



import java.util.logging.Logger;



import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="My Test Api"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class MyTestApi {
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String param1;
    
    @TestApiParameter(seq=2, 
            summary="The second parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public boolean param2;

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

    	/*// Put our implementation logic here.
    			testLogger.info("Running" + this.getClass().getName());
    			String PDFContent=null;
    			if(IsURL==false)
    			{
    			String filePath=null;
    			String currentDir=System.getProperty("user.home")+File.separator+ "Downloads";	
    			testLogger.info(currentDir);

    			File dir = new File(currentDir);
    			File[] dirFileList =  dir.listFiles();
    			

    			for(int i=0;i<dirFileList.length;i++)
    			{
    				if(dirFileList[i].getName().equalsIgnoreCase(fileName))

    				{
    					Path srcPath= Paths.get(dirFileList[i].getAbsolutePath());
    					filePath=srcPath.toString();
    					testLogger.info(filePath);			
    				}
    			}
    			File file = new File(filePath);
    			PDDocument document = PDDocument.load(file);
    			//Instantiate PDFTextStripper class
    			PDFTextStripper pdfStripper = new PDFTextStripper();
    			//Retrieving text from PDF document
    			PDFContent = pdfStripper.getText(document);	
    			testLogger.info(PDFContent);
    			//Closing the document
    			document.close();
    			}
    			
    			else
    			{
    				testLogger.info("inside else");
    				//URL url = new URL(fileName);
    				URLConnection urlConnection = new URL(fileName).openConnection();
    				urlConnection.addRequestProperty("User-Agent", "Chrome");
    				testLogger.info("debug0");
    				InputStream input = new URL(fileName).openStream();
    		        testLogger.info("debug0");
    		        BufferedInputStream fileToParse = new BufferedInputStream(input);
    		        PDDocument document = null;
    		        testLogger.info("debug1");
    		            document = PDDocument.load(fileToParse);
    		            testLogger.info("debug2");
    		            PDFContent = new PDFTextStripper().getText(document);
    		           testLogger.info(PDFContent);

    		     
    			}
    			
    			// Store the result (if appropriate).
    			testExecutionContext.setValue(resultName, PDFContent, resultScope);
    			
    }*/
    }
}
