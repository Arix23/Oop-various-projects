

public class Preferences {
	private static Preferences uniqueInstance = null;
	private boolean shareInfo;
	
	private Preferences()
	{
		this.shareInfo = false;
	}
	
	public static Preferences getInstance()
	{
		if(uniqueInstance == null) {
			return new Preferences();
		}
		return uniqueInstance;
	}
	
	public void setShareInfo(boolean value)
	{
		this.shareInfo = value;
	}
	
	public String toString()
	{
		return "Application Preferences:\nShare information: " + this.shareInfo; 
	}
}
