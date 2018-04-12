package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;


/**
 * Это класс время.
 * Он содержит все необходимые переменные и функции, связанные с таймером в главном графическом интерфейсе
 * Он использует класс таймера
 *
 */

public class Time
{
    private JLabel label;
    Timer countdownTimer;
    int Timerem;
    public Time(JLabel passedLabel)
    {
       countdownTimer = new Timer(1000, new CountdownTimerListener());
       this.label = passedLabel;
       Timerem=Main.timeRemaining;
    }
    
    //Функция, которая запускает таймер
    public void start()
    {
    	countdownTimer.start();
    }
    
    //Функция, которая сбрасывает таймер
    public void reset()
    {
    	Timerem=Main.timeRemaining;
    }
    
    //Функция, вызываемая через каждую секунду. Он обновляет таймер и принимает другие необходимые действия
    class CountdownTimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
       	 int min,sec;
       	 if (Timerem > 0)
       	 {
           	min=Timerem/60;
           	sec=Timerem%60;
            label.setText(String.valueOf(min)+":"+(sec>=10?String.valueOf(sec):"0"+String.valueOf(sec)));
            Timerem--;
         }
       	 else
       	 {
               label.setText("Time's up!");
               reset();
               start();
               Main.Mainboard.changechance();
		 }
    }
 }
}