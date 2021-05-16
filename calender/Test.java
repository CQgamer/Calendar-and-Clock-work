package calender;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Test {
 public Test(JFrame j){

	 
  Clock clock=new Clock();
  
  Calender cal =  new Calender();
  
  j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  j.setBounds(500,200,650, 300);
  
  j.setVisible(true);
  
  j.setContentPane(clock);
  
  j.getContentPane().add(cal,BorderLayout.WEST);
  
  j.setResizable(false);
 }
 
 public static void main(String[] args){
	JFrame j = new JFrame();
	
    Test test =new Test(j);
  
  j.setTitle("万年历和时钟");
 }  
}






