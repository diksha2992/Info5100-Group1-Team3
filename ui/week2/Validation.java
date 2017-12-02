import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

class Validation 
{
	String empty="should not be empty.\n";
	String special="should not contain special characters.\n";
    public String ValidateDisclaimer(String disclaimer)
    {
    	if(!IsNullOrEmpty(disclaimer))
    		return "true";
    	else
    		return "Disclaimer : should not be empty.\n";
    }
    
    public String ValidatetitleText(String titleText)
    {
    	if(!IsNullOrEmpty(titleText)&&ContainsSpecialCharacters(titleText))
    		return "Title : "+special;
    	else if(!IsNullOrEmpty(titleText))	
    		return "true";
    	else
    		return "Title : "+empty;
    }
    
    public String ValidatediscountText(String discountText)
    {
    	if(IsNullOrEmpty(discountText))
    		return "Discount : "+empty;
    	else if(Pattern.matches("[0-9]{1,4}",discountText))
    		return "Discount : should contain only numbers and maximum value is 9999$.\n";
    	else
    		return "true";
    }
    
    public String ValidatedescriptionText(String descriptionText)
    {
    	if(IsNullOrEmpty(descriptionText))
    		return "Description : "+empty;
    	else
    		return "true";
    }
    
    public String ValidatemakeText(String makeText)
    {
    	if(ContainsSpecialCharacters(makeText))
    		return "Make : "+special;
    	else if(IsNullOrEmpty(makeText))
    		return "Make : "+empty;
    	else
    		return "true";
    }
    
    public String ValidatemodelText(String modelText)
    {
    	if(ContainsSpecialCharacters(modelText))
    		return "Model : "+special;
    	else if(IsNullOrEmpty(modelText))
    		return "Model : "+empty;
    	else
    		return "true";
    }
    
    public String ValidateyearText(String yearText)//special year,special month
    {
    	if(!IsNullOrEmpty(yearText)&&!Pattern.matches("[1][9][1-9][0-9]|[2][0][0][0-9]|[2][0][1][0-8]", yearText))
    	    return "Year : should be between 1910 to 2018.\n";
    	else if(IsNullOrEmpty(yearText))
    	    return "Year :"+empty;
    	else
    		return "true";
    }
    
    
    
    public String ValidatepriceText(String priceText)
    {
    	if(IsNullOrEmpty(priceText))
    		return "Price : "+empty;
    	else if(!isNumberAndDot(priceText))
    		return "Please input valid price.\n";
    	else
    		return "true";
    }
    
    public String ValidatemilleageText(String millege)
    {
    	if(IsNullOrEmpty(millege))
    		return "Millege : "+empty;
    	else if(!isNumberAndDot(millege))
    		return "Please input valid price.\n";
    	else
    		return "true";
    }
    
    public String ValidateStartDate(String startDate) throws ParseException
    {
    		return checkDate(startDate);
    }
    
    public String ValidateEndDate(String startDate,String endDate) throws ParseException
    {
    	if(checkDate(endDate).equals("true")&&checkDate(startDate).equals("true"))
    	{
    		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		    String Nowdate = sdf.format(new Date());//获取当前时间
		    String  validDate= "2016-11-23";   //到期时间

		 if(sdf.parse(Nowdate).getTime() > sdf.parse(validDate).getTime()){
		    return "Please input valid end date.\n";
		}else{
		  return "true";
		}
    	}
    	else
    		return checkDate(endDate);
    }
    
    
    private boolean isNumberAndDot(String arr) {
		if(Pattern.matches("^[0-9]+(.[0-9]{2})?$", arr)) {
			return true;
		}
		return false;
	}
    public boolean IsNullOrEmpty(String text) {
        return (text == null || text.trim().isEmpty());
    }

    public boolean IsNullOrEmpty(StringBuilder text) {
        return (text == null || text.toString().trim().isEmpty());
    }
    
    private static String checkDate(String strDateTime) throws ParseException {//check if the date is valid
		String[] time=strDateTime.split("-");
		if(time.length!=3)
			return "Please input your date in the format of yyyy-mm-dd.\n";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date ndate = (Date) format.parse(strDateTime);
        String str = format.format(ndate);
        if (str.equals(strDateTime))
                return "true";//validate
        else
                return "Please input valid time.\n";//not validate
    }
    
    public boolean ContainsSpecialCharacters(String text) {
        return !Pattern.matches("[a-zA-Z0-9 ]*", text);
    }
}