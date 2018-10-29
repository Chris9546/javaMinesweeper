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
	cell [] bombList;
	
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
	
	public cell(cell c)
	{
		i = c.i;
		isBomb = c.isBomb;
		x = c.x;
		y = c.y;
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
	
	public static int[][] placeNumber(cell[][] g, int[][] b, cell[] bombs)
	{
		for(int i = 0;i<16;i++)
		{
			for(int k = 0;k<16;k++)
			{
				if(b[i][k] == 0)
				{
					b[i][k] = g[i][k].countBombs(bombs);
				}
			}
		}
		
		return b;
	}
	
	public int countBombs(cell[] bombs)
	{
		int count = 0;
		
		int startX = -1;
		int startY = -1;
		int endX = 1;
		int endY = 1;
		
		if(x == 0)
		{
			startX = 0;
		}
								
		if(y == 15)
		{
			endY = 0;
		}
		
		if(x == 15)
		{
			endX = 0;
		}
		
		if(y == 0)
		{
			startY = 0;
			
		}
		
		
		
		
		for(int i = startX;i<=endX;i++)
		{
			for(int k = startY;k<=endY;k++)
			{
				if(i == 0 && k == 0)
				{
					for(int j = 0;j<bombs.length;j++)
					{						
						if(this.equalTo(bombs[j]) == true)
						{
							return -1;
						}
						
					}
				}
				else
				{
					cell unknownBmb = new cell(false, i+x, k+y);
					for(int j = 0;j<bombs.length;j++)
					{						
						if(unknownBmb.equalTo(bombs[j]) == true)
						{
							count += 1;
						}
						
					}					
					

				}
			}
		}
		
		return count;
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
			
			for(int i = 0;i<bombList.size();i++)
			{
				if(c.equalTo(bombList.get(i)) == true)
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
				bombsInt[c[i].x][c[i].y] = 9;
			}
			else
			{
				bombsInt[c[i].x][c[i].y] = 0;
			}
		}
		
		return bombsInt;
	}
}