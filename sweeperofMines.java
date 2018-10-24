package School;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.image.Image;
import java.io.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.Random;
import School.cell;

public class sweeperofMines extends Application
{
	@Override
	public void start(Stage stage) throws IOException
	{
		// grid, minesLeft, oneView
		Group root = new Group();
		Scene scene = new Scene(root, 800, 800);
		scene.setFill(Color.GRAY);
		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		
		// Image Size is 30 x 30
		
		Image empty = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\empty.png"));
		
		Image covered = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\covered.png"));
		
		Image bomb = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\bomb.png"));
		
		Scanner sc = new Scanner("System.in");
		GridPane grid = new GridPane();
		
		ImageView[][] gridButtons = new ImageView[16][16];
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				ImageView coveredView = new ImageView(covered);
				ImageView emptyView = new ImageView(empty);
				
				coveredView.setOnMouseClicked((event)->
				{
		            
		        });
				
				gridButtons[i][k] = coveredView;
				grid.add(gridButtons[i][k], i, k);
			}
		}
		
		TextField minesLeft = new TextField();
		minesLeft.setTranslateX(200);
		minesLeft.setTranslateY(50);
		minesLeft.setText("10");
		minesLeft.setPrefWidth(30.0f);
		minesLeft.setStyle("-fx-border-color: black;");
		minesLeft.setEditable(false);
		minesLeft.setMouseTransparent(true);
		minesLeft.setFocusTraversable(false);
		minesLeft.setVisible(true);
		
		int temp = 0;
		int[][] bombs = new int[16][16];
		bombs = placeBombs();
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				if(bombs[i][k] == 1)
				{
					temp+=1;
				}
			}
		}
		
		System.out.println(temp);
		
		grid.setTranslateX((scene.getHeight()/2)/2-10);
		grid.setTranslateY((scene.getWidth()/2)/2);
		
		root.getChildren().add(grid);
		root.getChildren().add(minesLeft);
		
		stage.show();
	}
	
	public static void main(String args[]) throws IOException
	{
		launch(args);
	}
}