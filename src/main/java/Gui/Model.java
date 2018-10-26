package Gui;

public class Model {

private View view;
public Model(View view) {
    this.view = view;
}

public void changeText() {
    view.getLblNewLabel().setText("Changed text");
}

}