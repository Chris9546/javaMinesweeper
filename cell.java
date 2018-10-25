package School;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.ImageView;

public class cell 
{
	ImageView i;
	boolean isBomb;
	int x;
	int y;

	public cell()
	{
		i = null;
		isBomb = false;
		x = 0;
		y = 0;
	}
	
	public cell(boolean isB, int a, int b, ImageView l)
	{
		i = l;
		isBomb = isB;
		x = a;
		y = b;
	}
	
	public cell(boolean isB, int a, int b)
	{
		isBomb = isB;
		x = a;
		y = b;
	}
	
	public boolean equalTo(cell c)
	{
		if(this.x == c.x && this.y == c.y)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static cell[][] placeNumbers(cell[][] g, int[][] b)
	{
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				if(b[i][k] == 0)
				{
					
				}
			}
		}
	}
	
	public static int countBombs(cell[][] g, int[][]b, cell c, int count)
	{
		int count = 0;
		if(b[c.x-1] [c.y+1] == 1)
		{
			count += 1;
			
		}
		
	}
	
	// 8 Cells to check 

}