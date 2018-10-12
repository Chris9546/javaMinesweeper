package School;

import School.cell;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.beans.EventHandler;
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class sweeperofMines extends Application
{
	@Override
	public void start(Stage stage) throws IOException
	{
		Image one = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\1.png"));
		ImageView oneView = new ImageView(one);
		
		Image two = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\2.png"));
		ImageView twoView = new ImageView(two);
		
		Image three = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\3.png"));
		ImageView threeView = new ImageView(three);
		
		Image four = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\4.png"));
		ImageView fourView = new ImageView(four);
		
		Image five = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\5.png"));
		ImageView fiveView = new ImageView(five);
		
		// Image Size is 30 x 30
		
		Image empty = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\empty.png"));
		ImageView emptyView = new ImageView(empty);
		
		Image covered = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\covered.png"));
		ImageView coveredView = new ImageView(covered);
		
		Image bomb = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\bomb.png"));
		ImageView bombView = new ImageView(bomb);
		
		Image flag = new Image(new FileInputStream("C:\\Users\\khscs091\\eclipse-workspace\\School\\flag.png"));
		ImageView flagView = new ImageView(flag);
		
		Scanner sc = new Scanner("System.in");
		GridPane grid = new GridPane();
		
		cell[][] gridButtons = new cell[16][16];
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				cell c = new cell(coveredView, i, k);
				
				gridButtons[i][k] = c;
				
				c.i.setOnMouseClicked((event)->
				{
					c.i = emptyView;
					grid.add(gridButtons[i][k].i, gridButtons[i][k].x, gridButtons[i][k].y);
				});
				
			}
		}
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				grid.add(gridButtons[i][k].i, gridButtons[i][k].x, gridButtons[i][k].y);
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
		
		
		Group root = new Group(grid, minesLeft, oneView);
		
		Scene scene = new Scene(root, 800, 800);
		scene.setFill(Color.GRAY);
		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		
		grid.setTranslateX((scene.getHeight()/2)/2-10);
		grid.setTranslateY((scene.getWidth()/2)/2);
		
		stage.show();
		
	}
	
	public static void main(String args[]) throws IOException
	{
		launch(args);
	}
	
/*	public void placeBombs(Button[][] b)
	{
		
	} */
	
}