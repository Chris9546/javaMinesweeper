package School;

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
import java.awt.Image;
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
/*		BufferedImage img = ImageIO.read(new File("C:\\Users\\khscs091\\Downloads\\images.GIF"));
		
		BufferedImage flag = img.getSubimage(115, 235, 580, 202);
		BufferedImage questionMark = img.getSubimage(115, 235, 580, 202);
		BufferedImage exclamationPoint = img.getSubimage(115, 235, 580, 202);
		
		BufferedImage one = img.getSubimage(115, 235, 580, 202);
		BufferedImage two = img.getSubimage(115, 235, 580, 202);
		BufferedImage three = img.getSubimage(115, 235, 580, 202);
		BufferedImage four = img.getSubimage(115, 235, 580, 202);
		BufferedImage five = img.getSubimage(115, 235, 580, 202);
		BufferedImage six = img.getSubimage(115, 235, 580, 202);
		BufferedImage seven = img.getSubimage(115, 235, 580, 202);
		BufferedImage eight = img.getSubimage(115, 235, 580, 202);
		
		BufferedImage revealedGray = img.getSubimage(115, 235, 580, 202);
		BufferedImage nonrevealedGray = img.getSubimage(115, 235, 580, 202);
		
		BufferedImage bomb = img.getSubimage(115, 235, 580, 202);
		BufferedImage discoveredBomb = img.getSubimage(115, 235, 580, 202);
		
		BufferedImage neutral = img.getSubimage(115, 235, 580, 202);
		BufferedImage win = img.getSubimage(115, 235, 580, 202);
		BufferedImage lose = img.getSubimage(115, 235, 580, 202); */
		
		
		
		Scanner sc = new Scanner("System.in");
		GridPane grid = new GridPane();
		
		Button[][] gridButtons = new Button[16][16];
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				Button b1 = new Button("   ");
				
				b1.setOnAction(event -> 
				{
		            
		        });
				
				gridButtons[i][k] = b1;
			}
		}
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				grid.add(gridButtons[i][k], i, k);
			}
		}
		
		grid.setHgap(0);
		grid.setVgap(0);
		
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
		
		
		Group root = new Group(grid, minesLeft);
		
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
