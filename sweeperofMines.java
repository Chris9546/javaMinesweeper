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
		bombs = placeBombs(false);
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
	
	public static int[][] placeBombs(boolean x)
	{
		int[][] bombs = new int[16][16];		
		if(x == false)
		{
			for(int rows = 0;rows<16;rows++)
			{
				if(rows % 2 == 0)
				{
					Random a = new Random();
					Random b = new Random();
					
					int first = a.nextInt(16);
					int second = b.nextInt(16);
					
					bombs[rows][first] = 1;
					bombs[rows][second] = 1;
				}
				if(rows % 2 == 1)
				{
					Random a = new Random();
					Random b = new Random();
					Random c = new Random();
					
					int first = a.nextInt(16);
					int second = b.nextInt(16);
					int third = c.nextInt(16);
					
					bombs[rows][first] = 1;
					bombs[rows][second] = 1;
					bombs[rows][third] = 1;
				}
			}
			
			for(int rows = 0;rows<16;rows++)
			{
				for(int collums = 0;collums<16;collums++)
				{
					if(bombs[rows][collums] != 1)
					{
						bombs[rows][collums] = 0;
					}
				}
			}
		}
		else
		{
			int core = 2;
			int count = 0;
			for(int i = 0;i<16;i++)
			{
				if(i % 2 == 0)
				{
					core = 2;
				}

				if(i % 2 == 1)
				{
					core = 3;
				}
				
				for(int k = 0;k<16;k++)
				{
					if(bombs[i][k] == 1)
					{
						count += 1;
					}
				}
				
				if(core == 2 && count != core)
				{
					int a = core-count;
					for(int i = 0;i<a;i++)
					{
						
					}
				}
				if(core == 3 && count != core)
				{
					int a = core-count;
					for()
					{
						
					}
				}
			}
		}
		return bombs;
	}
	
	
	// 8 Cells to check
/*	public boolean checkforBombs()
	{
		
	} */
}