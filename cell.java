package School;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.ImageView;

public class cell 
{
	ImageView i;
	int x;
	int y;

	public cell(ImageView k, int a, int b)
	{
		i = k;
		x = a;
		y = b;
	}
	
	public cell(int a, int b)
	{
		x = a;
		y = b;
	}
	
	public static int[][] placeBombs()
	{
		int[][] bombs = new int[16][16];		
		
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
		return bombs;
	}
	
	public int[][] equalTo(int x, int y)
	{
		int[][] grid = new int[16][16];
		grid = placeBombs(); 
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				if(grid[x][y] == grid[this.x][this.y])
				{
					if(x >= 8)
					{
						Random ran = new Random();
						int n = ran.nextInt(7);
						grid[x][y] = grid[this.x][n];
					}
					else
					{
						Random ran = new Random();
						int n = ran.nextInt((16 - 9) + 1) + 9;
						grid[x][y] = grid[this.x][n];
					}
				}
			}
		}
		return grid;
	}
	
	
	
	
	
	// 8 Cells to check 
	
	public static boolean checkforBombs(int[][] g, int x, int y, boolean c)
	{
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		
		if(x == 0 && y == 0 || x == 0 && y == 15 || x == 15 && y == 0 || x == 15 && y == 15)
		{
			if(g[x][y] == 0)
			{
				
			}
			else
			{
				
			}
			for(int i = 0;i<8;i++)
			{
					
			}
		}
		else
		{
			if(g[x][y] == 0)
			{
				results.add(false);
			}
			else
			{
				results.add(true);
			}
		
			for()
			{
				
			}
		}
	} 
}
