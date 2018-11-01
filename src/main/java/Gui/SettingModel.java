package Gui;

public class SettingModel {

private SettingView view;
public SettingModel(SettingView view) {
    this.view = view;
}


public float getRetailerMax() {
	float i;
	try {
		i = Integer.parseInt(view.RetilerMax().getText());
	}catch(NumberFormatException ex) {
		i = 0;
	}
	return i;
}

public float getRetailerMin() {
	float i;
	try {
		i = Integer.parseInt(view.RetailerMin().getText());
	}catch(NumberFormatException ex) {
		i = 0;
	}
	return i;
}

public int getRetailAgents() {
	int i;
	try {
		i = Integer.parseInt(view.RetailAgents().getText());
	}catch(NumberFormatException ex) {
		i = 0;
	}
	return i;
}

public int getAplianceAgents() {
	int i;
	try {
		i = Integer.parseInt(view.AplianceAgents().getText());
	}catch(NumberFormatException ex) {
		i = 0;
	}
	return i;
}


public String[] getAppNames() {
	String[] Names = view.GetAppNames();

	return Names;
}

public String[] getRetailNames() {
	String[] Names = view.GetRetailNames();
	return Names;
}
}