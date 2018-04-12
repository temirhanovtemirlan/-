package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Это класс ферзя, унаследованный от абстрактного класса Piece
 *
 */
public class Queen extends Piece{
	
	//Конструктор
	public Queen(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//функция перемещении
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{
		//У ферзя больше всего возможных ходов
		//Ферзь может перемещать любое количество шагов во всех 8 направлениях
		//Возможные шаги Ферзя - комбинация Ладьи и Слона
		possiblemoves.clear();
		
		//Проверка возможных ходов в вертикальном направлении
		int tempx=x-1;
		while(tempx>=0)
		{
			if(state[tempx][y].getpiece()==null)
				possiblemoves.add(state[tempx][y]);
			else if(state[tempx][y].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx--;
		}
		
		tempx=x+1;
		while(tempx<8)
		{
			if(state[tempx][y].getpiece()==null)
				possiblemoves.add(state[tempx][y]);
			else if(state[tempx][y].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx++;
		}
		
		
		//Проверка возможных ходов в горизонтальном направлении
		int tempy=y-1;
		while(tempy>=0)
		{
			if(state[x][tempy].getpiece()==null)
				possiblemoves.add(state[x][tempy]);
			else if(state[x][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy--;
		}
		tempy=y+1;
		while(tempy<8)
		{
			if(state[x][tempy].getpiece()==null)
				possiblemoves.add(state[x][tempy]);
			else if(state[x][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy++;
		}
		
		//Проверка возможных ходов в диагональном направлении
		tempx=x+1;tempy=y-1;
		while(tempx<8&&tempy>=0)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy--;
		}
		tempx=x-1;tempy=y+1;
		while(tempx>=0&&tempy<8)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy++;
		}
		tempx=x-1;tempy=y-1;
		while(tempx>=0&&tempy>=0)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy--;
		}
		tempx=x+1;tempy=y+1;
		while(tempx<8&&tempy<8)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy++;
		}
		return possiblemoves;
	}
}