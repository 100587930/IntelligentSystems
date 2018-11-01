package Gui;

public class Model {

private View view;
public Model(View view) {
    this.view = view;
}




public int[] getCurrentNew() {
	int[] intArray = new int[7];
	intArray[0] = Integer.parseInt(view.Agent1New().getText());
	intArray[1] = Integer.parseInt(view.Agent2New().getText());
	intArray[2] = Integer.parseInt(view.Agent3New().getText());
	intArray[3] = Integer.parseInt(view.Agent4New().getText());
	intArray[4] = Integer.parseInt(view.Agent5New().getText());
	return intArray;
}

public void AssignNewValues(Float values, int agents) {
		switch(agents) {
		case 0: view.Agent1Old().setText(view.Agent1New().getText()); break;
		case 1: view.Agent2Old().setText(view.Agent2New().getText()); break;
		case 2: view.Agent3Old().setText(view.Agent3New().getText()); break;
		case 3: view.Agent4Old().setText(view.Agent4New().getText()); break;
		case 4: view.Agent5Old().setText(view.Agent5New().getText()); break;
		}
		switch(agents) {
		case 0: view.Agent1New().setText(Float.toString(values));break;
		case 1: view.Agent2New().setText(Float.toString(values));break;
		case 2: view.Agent3New().setText(Float.toString(values));break;
		case 3: view.Agent4New().setText(Float.toString(values));break;
		case 4: view.Agent5New().setText(Float.toString(values));break;
		}
	}

public void AssignOldValues(int[] values, int agents) {
	int i = 0;
	while(i < agents) {
		switch(i) {
		case 0: view.Agent1Old().setText(Integer.toString(values[i]));break;
		case 1: view.Agent2Old().setText(Integer.toString(values[i]));break;
		case 2: view.Agent3Old().setText(Integer.toString(values[i]));break;
		case 3: view.Agent4Old().setText(Integer.toString(values[i]));break;
		case 4: view.Agent5Old().setText(Integer.toString(values[i]));break;
		}
		i++;
	}
}

public void AssignAppAgentsNames(String[] names) {
	for(int i = 0; i<5; i++) {
		view.setAppAgentNames()[i].setText(names[i]);
	}
}

public void AssignRetailAgentsNames(String[] names) {
	for(int i = 0; i<7; i++) {
		view.setRetailAgentNames()[i].setText(names[i]);
	}
}


public void AssignAccept(String values, int i) {
		switch(i) {
		case 0: view.Retail1Accept().setText(values);break;
		case 1: view.Retail2Accept().setText(values);break;
		case 2: view.Retail3Accept().setText(values);break;
		case 3: view.Retail4Accept().setText(values);break;
		case 4: view.Retail5Accept().setText(values);break;
		case 5: view.Retail6Accept().setText(values);break;
		case 6: view.Retail7Accept().setText(values);break;
		default:view.Retail1Accept().setText(values);
				view.Retail2Accept().setText(values);
				view.Retail3Accept().setText(values);
				view.Retail4Accept().setText(values);
				view.Retail5Accept().setText(values);
				view.Retail6Accept().setText(values);
				view.Retail7Accept().setText(values);
				break;
		}
	}

public void AssignProposed(float values, int agents) {
	int i = 0;
	while(i < agents) {
		switch(i) {
		case 0: view.Retail1Prop().setText(Float.toString(values));break;
		case 1: view.Retail2Prop().setText(Float.toString(values));break;
		case 2: view.Retail3Prop().setText(Float.toString(values));break;
		case 3: view.Retail4Prop().setText(Float.toString(values));break;
		case 4: view.Retail5Prop().setText(Float.toString(values));break;
		case 5: view.Retail6Prop().setText(Float.toString(values));break;
		case 6: view.Retail7Prop().setText(Float.toString(values));break;
		}
		i++;
	}
}

public void addData(float x, float y, int i) {
		view.addDataIndevidual(x, y, i);
}


public void setupLines(String Name, int i) {
		view.setupLinesindevidual(Name, i);
	}	
}
