package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.stage.Stage;



public class Polygon extends Application {
	private int sides = 3;
	private  double radius= 100;
	private  Polygon polygon = new Polygon();
    @Override
    public void start(Stage primaryStage) {
    	//creates the first shape
    	PlusMinusSides();
    	
    	//align buttons
    	//button + & -
    	Group root = new Group(); 
    	Button PlusButton = new Button("+");
    	PlusButton.setLayoutX(250);
    	PlusButton.setLayoutY(340);
    	
    	Button MinusButton = new Button(" -");
    	MinusButton.setLayoutX(200);
    	MinusButton.setLayoutY(340);
    	
    	//determining the max and min numbers for sides
        //button event handlers for plus and minus
		PlusButton.setOnAction(new EventHandler <ActionEvent>() {
			//max 25 sides
			@Override
			public void handle(ActionEvent event) {
			   	if(sides < 25) {
		    		sides++;
		    		PlusMinusSides();
		    	}
				
			}
		});
		
		MinusButton.setOnAction(new EventHandler <ActionEvent>() {
			
			//triangle minimum
			@Override
			public void handle(ActionEvent event) {
			   	if(sides > 3) {
		    		sides--;
		    		PlusMinusSides();
		    	}
				
			}
		});
		
        // Creates a scene and displays everything
        Scene scene = new Scene(root, 500, 500);
        
        root.getChildren().add(PlusButton);
        root.getChildren().add(MinusButton);
        root.getChildren().add(polygon);
   
        primaryStage.setResizable(true);
        primaryStage.setTitle("project 6 ch: 15.4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //the math for adding and subtracting sides/ determine number of sides 
    //void method to add into the FX method
    public void PlusMinusSides() {
    	polygon.getPoints().clear();
        double centerX = 240;
        double centerY = 210;
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            polygon.getPoints().addAll(x, y);
        }
        //adds color to the polygon
        polygon.setFill(Color.BLACK);
        
    }
//launches the scene
    public static void main(String[] args) {
        launch(args);
    }
}