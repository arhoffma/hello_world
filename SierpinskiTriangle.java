/**
Sierpinski Triangle displays a fractal pattern 
using recursion
**/
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class SierpinskiTriangle extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		SierpinskiTrianglePane pane = new SierpinskiTrianglePane(); // recursive triangle pane
		TextField tfOrder = new TextField();
		tfOrder.setOnAction(
				e -> pane.setViewOrder(Integer.parseInt(tfOrder.getText()))); // listener for text field
		tfOrder.setPrefColumnCount(4);
		tfOrder.setAlignment(Pos.BOTTOM_RIGHT);
		
		// pane to hold label, text field, and button
		HBox hBox = new HBox(10); // hold label and text field
		hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
		hBox.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);
		
		//create scene and place in stage
		Scene scene = new Scene(borderPane, 200, 210);
		primaryStage.setTitle("Sierpinski Triangle"); // set stage title
		primaryStage.setScene(scene); // place scene in stage
		primaryStage.show(); // display the stage
		
		pane.widthProperty().addListener(ov->pane.paint());
		pane.heightProperty().addListener(ov->pane.paint());
	}
	
	
	static class SierpinskiTrianglePane extends Pane {
	
		private int order = 0;
		
		// Set a new order
		public void setOrder(int order) {
			this.order = order;
			paint();
		}
		
		SierpinskiTrianglePane() {
		}
		
		protected void paint() {
			//select three points in proportion to the pane size
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(10, getHeight() -10);
			Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
			
			this.getChildren().clear();
			
			displayTriangles(order, p1, p2, p3);
		}
		
		private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
			if (order == 0) {
				// draw a triangle to connect three points
				Polygon triangle = new Polygon();
				triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
				triangle.setStroke(Color.BLACK);
				triangle.setFill(Color.WHITE);
				
				this.getChildren().add(triangle);
			}
			
			else {
				// get the midpoint on each edge in the triangle
				Point2D p12 = p1.midpoint(p2);
				Point2D p23 = p2.midpoint(p3);
				Point2D p31 = p3.midpoint(p1);
				
				// Recursively display three triangles
				displayTriangles(order - 1, p1, p12, p31);
				displayTriangles(order - 1, p12, p2, p23);
				displayTriangles(order - 1, p31, p23, p3);
			}
		}
		
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
