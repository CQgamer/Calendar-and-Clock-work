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
  //���ò��������ı߿򲼾�
  this.setOpaque(false);
  //���ñ߿�Ϊ͸����
  this.add(clock);
  this.setBorder(new TitledBorder("����ʱ�� "));
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
//��������ʱ���Ĳ���