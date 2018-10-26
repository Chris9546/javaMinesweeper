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
	
	public static int[][] placeNumbers(cell[][] g, int[][] b)
	{
		ArrayList<Integer>x = new ArrayList<Integer>(); 
		ArrayList<Integer>y = new ArrayList<Integer>();
		
		x.add(-1);
		x.add(0);
		x.add(1);
		x.add(-1);
		x.add(1);
		x.add(-1);
		x.add(0);
		x.add(1);
		
		y.add(-1);
		y.add(-1);
		y.add(-1);
		y.add(0);
		y.add(0);
		y.add(1);
		y.add(1);
		y.add(1);
		
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				int count = 0;
				count = countBombs(b, g[i][k], count, x, y);
				b[i][k] = count;
			}
		}
		return b;
	} 
	
	public static int countBombs(int[][]b, cell c, int count, ArrayList<Integer>x, ArrayList<Integer>y)
	{
		x.add(-1);
		x.add(0);
		x.add(1);
		x.add(-1);
		x.add(1);
		x.add(-1);
		x.add(0);
		x.add(1);
		
		y.add(-1);
		y.add(-1);
		y.add(-1);
		y.add(0);
		y.add(0);
		y.add(1);
		y.add(1);
		y.add(1);
		
		for(int i = 0;i<1;i++)
		{
			if(b[c.x+x.get(i)] [c.y+y.get(i)] == 1)
			{
				x.remove(i);
				y.remove(i);
				return countBombs(b, c, count+=1, x, y);
			}
		}
		
		if(x.size() == 0)
		{
			return count;
		}
		return count; 
	}
	
	// 8 Cells to check 

}