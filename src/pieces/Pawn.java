package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Это класс пешки, унаследованный от pieces
 *
 */
public class Pawn extends Piece{
	
	//Конструктор
	public Pawn(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//Функция перемещения
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{
		// Пешка может перемещаться только на один шаг, кроме первого шанса, когда она может перемещаться на 2 шага
// Онa может двигаться по диагонали только для атаки части противоположного цвета
// Онa не может двигаться назад или двигаться вперед, чтобы аттаковать фигуру
		
		possiblemoves.clear();
		if(getcolor()==0)
		{
			if(x==0)
				return possiblemoves;
			if(state[x-1][y].getpiece()==null)
			{
				possiblemoves.add(state[x-1][y]);
				if(x==6)
				{
					if(state[4][y].getpiece()==null)
						possiblemoves.add(state[4][y]);
				}
			}
			if((y>0)&&(state[x-1][y-1].getpiece()!=null)&&(state[x-1][y-1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x-1][y-1]);
			if((y<7)&&(state[x-1][y+1].getpiece()!=null)&&(state[x-1][y+1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x-1][y+1]);
		}
		else
		{
			if(x==8)
				return possiblemoves;
			if(state[x+1][y].getpiece()==null)
			{
				possiblemoves.add(state[x+1][y]);
				if(x==1)
				{
					if(state[3][y].getpiece()==null)
						possiblemoves.add(state[3][y]);
				}
			}
			if((y>0)&&(state[x+1][y-1].getpiece()!=null)&&(state[x+1][y-1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x+1][y-1]);
			if((y<7)&&(state[x+1][y+1].getpiece()!=null)&&(state[x+1][y+1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x+1][y+1]);
		}
		return possiblemoves;
	}
}
