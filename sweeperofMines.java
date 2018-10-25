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

import java.util.ArrayList;
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
		cell[][] squareGrid = new cell[16][16];
		
		ImageView[][] gridButtons = new ImageView[16][16];
		
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				ImageView coveredView = new ImageView(covered);
				ImageView emptyView = new ImageView(empty);
				
				cell c = new cell(false, i, k, coveredView);
				
				c.i.setOnMouseClicked((event)->
				{
		            c.i.setImage(empty);
		        });
				
				squareGrid[i][k] = c;
				grid.add(squareGrid[i][k].i, i, k);
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
		cell[] bombs = new cell[16];
		
//		bombs = placeBombs();
		
//		int[][] bombsInt = new int[16][16];
		
//		bombsInt = placeBombsInt(bombs);
		
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
	
	public static cell[] placeBombs()
	{
		cell[] bombs = new cell[40];
		ArrayList<cell> bombList = new <cell>ArrayList();
		
		Random startX = new Random();
		Random startY = new Random();
		
		int x = startX.nextInt(16);
		int y = startY.nextInt(16);
		
		cell start = new cell(true, x, y);
		
		bombList.add(start);
		
		while(bombList.size() < 40)
		{
			Random r1 = new Random();
			Random r2 = new Random();
			
			int a = r1.nextInt(16);
			int b = r2.nextInt(16);
			
			cell c = new cell(true, a, b);
			
			int count = 0;
			
			for(int i = 0;i<=bombList.size();i++)
			{
				if(c.equalTo(bombList.get(i)))
				{
					break;
				}
				
				if(c.equalTo(bombList.get(i)) == false)
				{
					count += 1;
				}
				
				if(count == bombList.size())
				{
					bombList.add(c);
					break;
				}
			}
		}
		
		for(int i = 0;i<40;i++)
		{
			bombs[i] = bombList.get(i);
		}
		
		return bombs;
	}
	
	public static int[][] placeBombsInt(cell[] c)
	{
		int[][] bombsInt = new int[16][16];
		
		for(int i = 0;i<40;i++)
		{
			if(c[i] != null)
			{
				bombsInt[c[i].x][c[i].y] = 1;
			}
			else
			{
				bombsInt[c[i].x][c[i].y] = 0;
			}
		}
		
		return bombsInt;
	}
	
	public static boolean checkforBombs(cell[][] g, cell c, boolean firstClick)
	{
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		
		int x = c.x;
		int y = c.y;
		
		if(g[x][y].isBomb == false)
		{
			
		}
		
	}
}