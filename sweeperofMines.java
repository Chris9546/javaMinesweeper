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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
		
		Image flag = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\flag.png"));
		
		Image one = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\1.png"));
		
		Image two = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\2.png"));
		
		Image three = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\3.png"));
		
		Image four = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\4.png"));
		
		Image five = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\5.png"));
		
		Image six = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\6.png"));
		
		Image seven = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\7.png"));
		
		Image eight = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\8.png"));
		
		TextField minesLeft = new TextField();
		minesLeft.setTranslateX(200);
		minesLeft.setTranslateY(50);
		minesLeft.setText("10");
		minesLeft.setPrefWidth(35.0f);
		minesLeft.setStyle("-fx-border-color: black;");
		minesLeft.setEditable(false);
		minesLeft.setMouseTransparent(true);
		minesLeft.setFocusTraversable(false);
		minesLeft.setVisible(true);
		
		GridPane grid = new GridPane();
		cell[][] squareGrid = new cell[16][16];
		cell[] bombs = new cell[40];
		boolean [] gameDone = new boolean[1];
		gameDone[0] = false;
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				ImageView coveredView = new ImageView(covered);
				
				cell c = new cell(false, i, k, coveredView);
				
				c.i.setOnMouseClicked((event)->
				{
					MouseButton button = event.getButton();
					
					if(gameDone[0] == true)
					{
						return;
					}
					
					int x = c.x;
					int y = c.y;
					
					if(button == MouseButton.SECONDARY)
					{
						c.i.setImage(flag);
						return;
					}
					
					if(bombs[0] == null)
					{
						final cell[] b = cell.placeBombs();
						for(int m=0; m<bombs.length;m++)
						{
							bombs[m] = b[m];
						}
					}
					
					
					
					cell clicked = new cell(false,x,y);
					
					int bombsAround = clicked.countBombs(bombs);				
					
					switch(bombsAround)
					{
					case -1:
						c.i.setImage(bomb);
						gameDone[0] = true;
						break;
					case 0:
						for(int a = 16-c.x;a<16;a++)
						{
							for(int b = 16-c.y;b<16;b++)
							{
								if(squareGrid[a][b].countBombs(bombs) == 0)
								{
									squareGrid[a][b].i.setImage(empty);
								}
							}
						}
						
						break;
					case 1:
						c.i.setImage(one);
						break;
					case 2:
						c.i.setImage(two);
						break;
					case 3:
						c.i.setImage(three);
						break;
					case 4:
						c.i.setImage(four);
						break;
					case 5:
						c.i.setImage(five);
						break;
					case 6:
						c.i.setImage(six);
						break;
					case 7:
						c.i.setImage(seven);
						break;
					case 8:
						c.i.setImage(eight);
						break;
					}
					
		        });
										
				squareGrid[i][k] = c;
				grid.add(squareGrid[i][k].i, i, k);
			}
		}
		
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