package UI;

import java.io.File;

public class UISingleton {

	private File xmlFile;
	private String coAuthSelected;

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
}
