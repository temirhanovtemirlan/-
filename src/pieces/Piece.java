package pieces;

import java.util.ArrayList;

import chess.Cell;


/**
 * Это класс фигур. Это абстрактный класс, из которого наследуются все фактические части.
 * Он определяет всю функцию, общую для всех частей
 * Функция move () представляет собой абстрактную функцию, которая должна быть переопределена во всех унаследованных классах
 * Он реализует Cloneable интерфейс, поскольку копия фрагмента требуется очень часто
 */
public abstract class Piece implements Cloneable{

	//Переменные
	private int color;
	private String id=null;
	private String path;
	protected ArrayList<Cell> possiblemoves = new ArrayList<Cell>();  //Protected (access from child classes)
	public abstract ArrayList<Cell> move(Cell pos[][],int x,int y);  //Abstract Function. Must be overridden
	
	//Установка ID
	public void setId(String id)
	{
		this.id=id;
	}
	
	//выбор пути
	public void setPath(String path)
	{
		this.path=path;
	}
	
	//выбор цвета
	public void setColor(int c)
	{
		this.color=c;
	}
	
	//Получить путь
	public String getPath()
	{
		return path;
	}
	
	//получить id
	public String getId()
	{
		return id;
	}
	
	//Получить цвет
	public int getcolor()
	{
		return this.color;
	}
	
	//Функция возвращает «мелкую» копию объекта. Копия имеет то же значение переменной, но различную ссылку
	public Piece getcopy() throws CloneNotSupportedException
	{
		return (Piece) this.clone();
	}
}