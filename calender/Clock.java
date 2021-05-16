package calender;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
public class Clock extends JPanel {
 private  UIManager.LookAndFeelInfo  looks[];
 private DrawClock clock;
 public Clock(){
  looks=UIManager.getInstalledLookAndFeels();
  changeTheLookAndFeel(2);
  clock=new DrawClock();
  clock.start();
  this.setLayout(new BorderLayout());
  //设置布置容器的边框布局
  this.setOpaque(false);
  //设置边框为透明的
  this.add(clock);
  this.setBorder(new TitledBorder("日期时间 "));
  setSize(300,300);
  setVisible(true);
 }
 private void changeTheLookAndFeel(int i) {
  try{
   UIManager.setLookAndFeel(looks[i].getClassName());
   SwingUtilities.updateComponentTreeUI(this);
  }catch(Exception e){
   e.printStackTrace();
  }
 }
}
//设置整体时历的布局