package view;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {

	//declared for access throughout class, as handlers are now attached via methods
	private Button addBtn, clearBtn, removeBtn, submitBtn;

	public ButtonPane() {

		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);

		addBtn = new Button("Add");
		clearBtn = new Button("Clear");
		removeBtn = new Button("Remove"); 
		submitBtn = new Button("Submit");
		submitBtn.setDisable(true); //initially disable submit button until items added
		addBtn.setDisable(true); //initially disable add button until both text fields are not empty
		
		this.getChildren().addAll(addBtn, clearBtn, removeBtn, submitBtn);

		for (Node n : this.getChildren()) {
			((Button) n).setPrefSize(70, 30); //set preferred size for each button
		}

	}

	/* Binds boolean bindings to the disable property of the submit and add button
	 * so that they will be disabled whenever the binding attached registers true */
	public void submitBtnDisableBind(BooleanBinding value) {
		submitBtn.disableProperty().bind(value);
	}
	
	public void addBtnDisableBind(BooleanBinding property) {
		addBtn.disableProperty().bind(property);
	}
	
	
	//these methods allow handlers to be externally attached to this view
	public void addAddHandler(EventHandler<ActionEvent> handler) {
		addBtn.setOnAction(handler);
	}

	public void addClearHandler(EventHandler<ActionEvent> handler) {
		clearBtn.setOnAction(handler);
	}

	public void addRemoveHandler(EventHandler<ActionEvent> handler) {
		removeBtn.setOnAction(handler);
	}
	
	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		submitBtn.setOnAction(handler);
	}
	
}
