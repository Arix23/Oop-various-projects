package patterns;

public class Client {
		
	public static void main(String[] args) {
		Preferences pref = null;
		pref = Preferences.getInstance();
		pref.setShareInfo(true);
		System.out.println(pref.toString());
	}
}
