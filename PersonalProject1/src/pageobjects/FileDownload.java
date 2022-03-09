package pageobjects;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="FileDownload"                                
     , summary=""
     , relativeUrl=""
     , connection="PersonalOrg"
     )             
public class FileDownload {

	WebDriver driver;
	@TestLogger
    public Logger testLogger;
    
	
	public FileDownload(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Adobe PDFCNT00019737-QXY RESOURCES PTE_ LTD_-SGD-2022-01-15']")
	public WebElement FileNameField;
	
	@LinkType()
	@FindBy(xpath = "//a[@href*='/lightning/r/ContentDocument/0690o00000QewOWAAZ/view']")
	public WebElement hrefLink;
	
	public String readPDFContent() throws Exception {
	
		String appUrl="C:\\Users\\gaggan.rana\\Downloads\\CNT00019737-QXY RESOURCES PTE_ LTD_-SGD-2022-01-15 (1).pdf";
        URL url = new URL(appUrl);
        InputStream is = url.openStream();
        testLogger.info("InputStream");
        BufferedInputStream fileToParse = new BufferedInputStream(is);
        PDDocument document = null;
        String output = null;
        try {
            document = PDDocument.load(fileToParse);
            output = new PDFTextStripper().getText(document);
            testLogger.info(output);
        } finally {
            if (document != null) {
                document.close();
            }
            fileToParse.close();
            is.close();
        }
        return output;
    }

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='download the Provar Trial Guide']")
	public WebElement downloadTheProvarTrialGuide;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Testing With Different Profiles']")
	public WebElement testingWithDifferentProfiles;
    
 
			
}
