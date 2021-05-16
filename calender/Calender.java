package calender;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/*
1.������Ҫ�Ķ���ͱ�������
2.���ò��� 7*7��JLable[]����
3.���������е�����
*/

public class Calender extends JPanel implements ActionListener {
 public static final String HOUR_OF_DAY=null;
 JComboBox yearCom=new JComboBox();
 JComboBox monthCom = new JComboBox();
 //���������б���󣨶�����½�����������

 JLabel year_i=new JLabel("��");
 JLabel month_i=new JLabel("��");
 //����JLable���󣬲��ܼ��������Աߵı�ǩ
 
 Date nowDate =new Date();
 //ʱ������
 
 JLabel[]  jlabelDay= new JLabel[49];
 //JLabel�������飬Ϊ��ֵ����������
 
 int now_year=nowDate.getYear()+1900;
 //getYear() ���ص�ֵ���� 4 λ�����֣����ڽ��� 1900 �����ݣ�getYear() ���������������NowYear-1900

 int now_month=nowDate.getMonth();
 //����������������±���

 String String_year=null;
 int month_int=0;
 JPanel paneYM=new JPanel();
 JPanel paneDay =new JPanel();
 
 //������������
 
 //���캯����Ҫʵ��
 //1.����ݣ��·ݼ�����������
 //2./����������Ӹ��ֱ���
 //3.����������Ӹ��ֱ���
 //4.��������ģ�����������񲼾�
 //5.��������
 //6.���������ڴ��ڵĲ���
 
 public Calender(){
  super();
  for(int year=now_year-30;year<=now_year+30;year++){
   yearCom.addItem(year+"");
   //�ڿ�ͷ��������������б�����������
   //additem ��������Ͽ���б�������һ������������ҿ���ָ��������������
  
   
  }
  for(int i=1;i<13;i++){
   monthCom.addItem(i+"");
 //�ڿ�ͷ�������·������б�����������
 //additem ��������Ͽ���б�������һ������������ҿ���ָ��������������
 
  }
  
//����������Ӹ��ֱ���
  yearCom.setSelectedIndex(30);
  paneYM.add(yearCom);//�����������
  paneYM.add(year_i);//������ǩ
  monthCom.setSelectedIndex(now_month);
  paneYM.add(monthCom);//�����������
  paneYM.add(month_i);//���������ǩ
  
  //��������Ӽ�����
  monthCom.addActionListener( this);
  yearCom.addActionListener(this);
  
  //����paneDay���񲼾֣�(����,����,�м��,�м��));
  paneDay.setLayout(new GridLayout(7,7,10,10));
  
  //��������
  for(int i=0;i<49;i++){
   jlabelDay[i] =new JLabel("  ");
 //��ʼ��
   paneDay.add(jlabelDay[i]);
  }
  this.setDay();
  //���������ڴ��ڵĲ���
  this.setLayout(new BorderLayout());
  this.add(paneDay,BorderLayout.CENTER);
//���ñ߽粼�֣�����������
  this.add(paneYM,BorderLayout.NORTH);
  this.setSize(100,200);
  //���ñ߽粼�֣�����
  this.setBorder(new TitledBorder("����"));
  setSize(300,300);
 }
 //������������ļ��켸�� 7*7�ľ���
 
 
 //���������е�����
  void setDay() {
 
  String_year=yearCom.getSelectedItem().toString();
 //����ʱ��string�����������б�ȥ���
   month_int=monthCom.getSelectedIndex();
  
  int year_sel=Integer.parseInt(String_year)-1900;
  
  //                    ��ü��������б�������·�  ����Ϊ1��
  Date date= new Date(year_sel,month_int,1);
  GregorianCalendar cal=new GregorianCalendar();
  //������ֵ���·�ֵ��
  cal.setTime(date);
  String[] week={"������","����һ","���ڶ�","������","������","������","������"};
  int day=0;
  int day_week=0;
  
  for(int i=0;i<7;i++){
	   jlabelDay[i].setText(week[i]);
	 }//��ʾ������ʼһ�б�ǩ
  
	  if(month_int==0||month_int==2||month_int==4||month_int==6||month_int==9||month_int==11){
		  //�·��Ǵ�"0"��ʼ��
		  //1 3 5 7 8 10 12 Ϊ����
	   day=31;
	  }
	  else if(month_int==3||month_int==5||month_int==7||month_int==8||month_int==10){
		  		//2 4 6 
		     day=30;
	  			}else{
	  					if(cal.isLeapYear(year_sel)){
	  							// ����GregorianCalendar���� cal.isLeapYear �ж��Ƿ�������
	  							day=29;
	  					}else{
	  							day=28;
	  							}
	  				 }
	  
	  //���ô�Ų��֣����ݴ�ŵ��������滮����
	  
	  //�õ���������·ݵ�����   ��day����ʾ
	  
	  //ȥ�õ�  day�����ݽ�����һ��ѭ��
	  
	  
	  day_week=7+date.getDay();
	  
	  /*
	  date.getDay(); ��ȡ����ʱ�䣬��������ջ�ȡֵΪ��0������һΪ��1����~~����Ϊ��6��
	  +7ʹ��Ϊ ��1~��7������7��JFable[]
	    */
	  int count=1;
	  for(int i=day_week;i<day_week+day;count++,i++){
	   if(i %7==0||i==13||i==20||i==27||i==48||i==34||i==41){
		 //i%7==0 ��˼Ϊ������ ���ձ��ɫ������������Ϊred
	    if(i==day_week+nowDate.getDate()-1){
	    	
	    	//getDate()����  ���ر���ʱ��1~31  ����-1��������������i
	    	
	     jlabelDay[i].setForeground(Color.BLUE);
	     jlabelDay[i].setText(count+"*");       
	     //�ҳ���ǰ���ڣ�����ʾ����ɫ
	    }else{
	     jlabelDay[i].setForeground(Color.RED);
	     jlabelDay[i].setText(count+"");        
	     //����IF ������Ϊ
	     } }
	   else
	   {
	    if(i==day_week+nowDate.getDate()-1){
	     jlabelDay[i].setForeground(Color.BLUE);
	     jlabelDay[i].setText(count+"*");          
	//�ڵ�ǰ����������� ' ʹ֮������ʾ
	    }else
	    {
	     jlabelDay[i].setForeground(Color.BLACK);
	     jlabelDay[i].setText(count+"");
	//else  �������ط��ϼ�" "  ��˼�ǲ���  ����Ϊ��
	    }
	   }
	   }
	  
	   
  	  
 	   
 		   for(int i=7;i<day_week;i++){
 			   	jlabelDay[i].setText(" ");         
 	    //���·�һ��ǰ����Ϊ�ա� ��
 	   }
 		   for(int i=day_week+day;i<49;i++){
 			   	jlabelDay[i].setText(" ");
 	   }//���·��������һ����ϡ� �� �����������
 	  
 	  
 	   
 	   
 	 }//������������е����ڽ���
 
  
	 public void actionPerformed(ActionEvent e) {
	//����������
	  if(e.getSource()==yearCom||e.getSource()==monthCom){
	   this.setDay();
	  }
	 }
	 
	}








