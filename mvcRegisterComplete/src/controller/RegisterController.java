package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import model.Name;
import model.Register;

import view.ButtonPane;
import view.NamePane;
import view.RegisterRootPane;
import view.ViewPane;
import view.RegisterMenuBar;


public class RegisterController {

	//fields to be used throughout the class
	private NamePane np;
	private ButtonPane bp;
	private ViewPane vp;
	private RegisterMenuBar rmb;
	private Register model;

	public RegisterController(RegisterRootPane view, Register model) {
		//initialise model and view fields
		this.model = model;

		np = view.getNamePane();
		bp = view.getButtonPane();
		vp = view.getViewPane();
		rmb = view.getMenuBar();

		//attach event handlers to view using private helper method
		this.attachEventHandlers();	
		
		//attach bindings within view using private helper method
		this.attachBindings();
	}

	private void attachEventHandlers() {
		//attaching event handlers - some done as lambda expressions and some as inner classes
		bp.addAddHandler(new AddHandler());
		bp.addClearHandler(e -> np.clear());
		bp.addRemoveHandler(e -> vp.removeSelectedNames());
		bp.addSubmitHandler(new SubmitHandler());

		rmb.addLoadHandler(new LoadMenuHandler());
		rmb.addSaveHandler(new SaveMenuHandler());
		rmb.addExitHandler(e -> System.exit(0));
		rmb.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Register MVC app v2.0"));
		rmb.addIndividSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selected", null, "You selected " + vp.getSelectedItem()));
		rmb.addMultiSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selecteds", null, "You selected " + vp.getSelectedItems()));
	}
	
	/* this method attaches bindings in the view, e.g. for validation */
	private void attachBindings() {
		//attaches a binding such that the submit button in the view will be disabled whenever the contents of the ListView is empty
		bp.submitBtnDisableBind(Bindings.isEmpty(vp.getContents()));
		
		//attaches a binding such that the add button in the view will be disabled whenever either of the text fields in the NamePane are empty
		bp.addBtnDisableBind(np.isEitherFieldEmpty());
	}

	private class AddHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {	
			//retrieves name from view
			Name n = np.getNameInput();

			//check input not empty
			if(n.getFirstName().equals("") || n.getFamilyName().equals("")) {
				//output error
				alertDialogBuilder(AlertType.ERROR, "Error Dialog", null, "Need to input both first and family name!");

			} else {
				//adds it to the list view
				vp.addName(n);

				//resets name panel in view
				np.clear();
			}
		}
	}

	private class SubmitHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//add contents of the listview to the model and then clear it
			vp.getContents().forEach(n -> model.add(n));
			vp.clearNames();
		}
	}


	private class SaveMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registerObj.dat"));) {

				oos.writeObject(model);
				oos.flush();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Register saved to registerObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
			}
		}
	}

	private class LoadMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registerObj.dat"));) {

				model = (Register) ois.readObject();	

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Register loaded from registerObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

			//refresh the view with the names loaded back into the model
			vp.clearNames();
			model.forEach(vp.getContents()::add); //equivalent to n -> vp.getContents().add(n)
		}
	}

	//helper method to build dialogs
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
