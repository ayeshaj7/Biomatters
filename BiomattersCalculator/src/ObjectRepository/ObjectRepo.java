package ObjectRepository;

public class ObjectRepo {

WebDriver driver;
	
	//Web page objects
    By AssignInput=By.xpath("//h2[contains(text(),'Randomly choose a group for each subject')]/following-sibling:: div//input[@id='Nsubjects']");
    By SubjectToEachOfList=By.xpath("//h2[contains(text(),'Randomly choose a group for each subject')]/following-sibling:: div//select[@id='NGroups'][(text()='"+subjecttoeachof+"')]");  //With Dynamic value
    By RepeatList=By.xpath("//h2[contains(text(),'Randomly choose a group for each subject')]/following-sibling:: div//select[@id='NBlocks'][(text()='"+repeat+"')]");  //With Dynamic value
    By DoitButton=By.xpath("//h2[contains(text(),'Randomly choose a group for each subject')]/following-sibling:: div//button");
    By AssignHeader=By.xpath("//h1[contains(text(),'Assign subjects to groups')]");
    By ResultRows = By.xpath("//h1[contains(text(),'Assign subjects to groups')]/ancestor:: div/following-sibling::div//table//tr");
    By Record = By.xpath("//h1[contains(text(),'Assign subjects to groups')]/ancestor:: div/following-sibling::div//table//tr['\"+row+\"']/td['\"+column+\"']");//With Dynamic value
    
	
	//Select assign
	public void typeAssignValue(String assign){
		driver.findElement(AssignInput).sendKeys(assign);
	}
	
	//Select Subject to each of
	public void selectSubjecToEachOf(String subjecttoeachof){
        driver.findElement(SubjectToEachOfList).click;
    }
	
	//Select Repeat
	public void selectRepeat(String repeat){
        driver.findElement(RepeatList).click;
    }
	
	//Click on Doit button
	public void clickDoitButton(){
        driver.findElement(DoitButton).click;
        
        WebDriverWait wait=new WebDriverWait(driver, 15);
    	wait.until(ExpectedConditions.presenceOfElementLocated(AssignHeader));   
    }
	
	//Count the number of rows in the result
	public int countResultRecords(){
		int count=0;
        return count=driver.findElements(ResultRows).size();
    }
	
	//Check record data in 1st column
	public boolean validateFirstColumnRecords(){
		int rowCount=0;
        rowCount=countResultRecords();
        int []records;
        
        //Check the 1st column values
        for (int i=1; i<rowCount; i++){ 	
        	int row=i+1;
        	int column=1;
        	if (driver.findElements(Record).text()==i) {
        		records[i-0]=1;        		
        	}
        	else {
        		records[i-0]=0;    
        	}
        }
 
        //Check whether 1st column had correct values
        boolean output= false;
        List recordList = Arrays.asList(records);
        output= recordList.contains(0);
        return output;
    }
	
	//Check the number of times a value in a array
	public int countOfvalueInArray(ArrayList<?> array, Object value) {
	    int numCount = 0;
	    for (Object o : array) {
	        if (o.equals(value)) numCount++;
	    }
	    return numCount;
	}
	
	//Check record data in 2nd column
	public boolean validateSecondColumnRecords(int assignments){
		int rowCount=0;
	    rowCount=countResultRecords();
	    int []records;
	        
	    //Check the 2nd column values
	    for (int i=1; i<rowCount; i++){ 	
	      	int row=i+1;
	       	int column=2;
	       	records[i-0]=driver.findElements(Record).text();        		
	     }
	 
	    //Check whether 2nd column had correct values
	    for (int i=0; i<assignments;i++) {
	    	
	    	for(char assign = 'A'; assign <= 'Z'; ++assign) {
	    		string expectedAssignments[i]=assign;
	    	}
	    }
	    
	    if (countOfvalueInArray(records,expectedAssignments[0])==assignments) && (countOfvalueInArray(records,expectedAssignments[1])==assignments){
	    	return true;	
	    }
	    else {
	    	return false;	
	    }
	}
}
