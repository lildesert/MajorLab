package UI;

import java.io.File;
import java.util.HashMap;

public class UISingleton {

	private File xmlFile;
	private String coAuthSelected;
	private HashMap<String, Integer> mapCoAuth;

	private UISingleton() {
	}

	private static UISingleton INSTANCE = null;

	public static UISingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UISingleton();
		}
		return INSTANCE;
	}

	public File getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}
	
	public String getCoAuthSelected() {
		return coAuthSelected;
	}

	public void setCoAuthSelected(String coAuthSelected) {
		this.coAuthSelected = coAuthSelected;
	}
	
	public HashMap<String, Integer> getMapCoAuth() {
		return mapCoAuth;
	}

	public void setMapCoAuth(HashMap<String, Integer> mapCoAuth) {
		this.mapCoAuth = mapCoAuth;
	}
}
