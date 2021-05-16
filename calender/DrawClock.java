package calender;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DrawClock extends JPanel implements Runnable {
 Thread newThread;
 private JTextField timezone;
 
 public void start(){
  newThread=new Thread(this);
  newThread.start();
 }
 public void stop(){
  newThread=null;
 }
 
 public void paint(Graphics g){
  super.paint(g);

  setBorder(new TitledBorder("NowTime"));
  
  setBackground(Color.WHITE);
  
  Date nowDate =new Date();
  
  g.drawString(nowDate.toLocaleString(), 75, 120);
    //显示时间：  设置显示位置
 }
 //得到系统时间
 public Date getDate(){
  Date nowDate =new Date();
  return nowDate;
 }
 //刷新图层
 
 public void run() {
  while(newThread!=null){
   Date timeNow =new Date();
  }
 }
 
}