package chess;

import java.awt.*;
import javax.swing.*;

import pieces.*;

    
 // Это класс ячеек. Это маркерный класс нашего графического интерфейса.
//Всего 64 ячейки, которые составляют Шахматную доску
public class Cell extends JPanel implements Cloneable{
	
	//Переменные 
	private static final long serialVersionUID = 1L;
	private boolean ispossibledestination;
	private JLabel content;
	private Piece piece;
	int x,y;                             //является общедоступным, поскольку к нему должный обращаться все другие классы
	private boolean isSelected=false;
	private boolean ischeck=false;
	
	//Конструкторы
	public Cell(int x,int y,Piece p)
	{		
		this.x=x;
		this.y=y;
		
		setLayout(new BorderLayout());
	
	 if((x+y)%2==0)
	  setBackground(new Color(113,198,113));
	
	 else
	  setBackground(Color.white);
	 
	 if(p!=null)
		 setPiece(p);
	}
	
	//Конструктор, который принимает ячейку в качестве аргумента и возвращает новую ячейку, будет иметь те же данные, но другую ссылку
	public Cell(Cell cell) throws CloneNotSupportedException
	{
		this.x=cell.x;
		this.y=cell.y;
		setLayout(new BorderLayout());
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		if(cell.getpiece()!=null)
		{
			setPiece(cell.getpiece().getcopy());
		}
		else
			piece=null;
	}
	
	public void setPiece(Piece p)    //Функция для заполнении ячейки фигурой
	{
		piece=p;
		ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content=new JLabel(img);
		this.add(content);
	}
	
	public void removePiece()      //Функция удаления фигурый из ячейки
	{
		if (piece instanceof King)
		{
			piece=null;
			this.remove(content);
		}
		else
		{
			piece=null;
			this.remove(content);
		}
	}
	
	
	public Piece getpiece()    //Функция для доступа к фигуре конкретной ячейки
	{
		return this.piece;
	}
	
	public void select()       //Функция для маркировки ячейки, указывающей ее выбор
	{
		this.setBorder(BorderFactory.createLineBorder(Color.red,6));
		this.isSelected=true;
	}
	
	public boolean isselected()   //Функция возвращает, если ячейка находится под выбором
	{
		return this.isSelected;
	}
	
	public void deselect()     
	{
		this.setBorder(null);
		this.isSelected=false;
	}
	
	public void setpossibledestination()     //Функция, чтобы выделить ячейку, чтобы указать, что это возможный действительный ход
	{
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.ispossibledestination=true;
	}
	
	public void removepossibledestination()      //Удалите ячейку из списка возможных ходов
	{
		this.setBorder(null);
		this.ispossibledestination=false;
	}
	
	public boolean ispossibledestination()    //Функция, чтобы проверить, является ли ячейка возможным пунктом назначения
	{
		return this.ispossibledestination;
	}
	
	public void setcheck()     //Функция для выделения текущей ячейки, как отмечено (для короля)
	{
		this.setBackground(Color.RED);
		this.ischeck=true;
	}
	
	public void removecheck()   
	{
		this.setBorder(null);
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		this.ischeck=false;
	}
	
	public boolean ischeck()    //Функция проверки наличия текущей ячейки
	{
		return ischeck;
	}
}