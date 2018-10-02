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
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
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

public class sweeperofMines extends Application
{
	@Override
	public void start(Stage stage) throws IOException
	{		
		GridPane grid = new GridPane();
		
		Button[][] gridButtons = new Button[16][16];
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				Button b1 = new Button("  ");
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
		
		Group root = new Group(grid);
		
		Scene scene = new Scene(root, 800, 800);
		stage.setScene(scene);
		
		grid.setTranslateX((scene.getHeight()/2)/2+10);
		grid.setTranslateY((scene.getWidth()/2)/2);
		
		stage.show();
		
	}
	
	public static void main(String args[]) throws IOException
	{
		launch(args);
	}
	
}
