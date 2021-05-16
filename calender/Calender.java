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
1.将所需要的对象和变量设置
2.设置布局 7*7的JLable[]数组
3.设置日历中的日期
*/

public class Calender extends JPanel implements ActionListener {
 public static final String HOUR_OF_DAY=null;
 JComboBox yearCom=new JComboBox();
 JComboBox monthCom = new JComboBox();
 //创建下拉列表对象（对年和月进行下拉处理）

 JLabel year_i=new JLabel("年");
 JLabel month_i=new JLabel("月");
 //创建JLable对象，拆功能键下拉栏旁边的标签
 
 Date nowDate =new Date();
 //时间种类
 
 JLabel[]  jlabelDay= new JLabel[49];
 //JLabel创建数组，为设值界面做基础
 
 int now_year=nowDate.getYear()+1900;
 //getYear() 返回的值不是 4 位的数字！对于介于 1900 后的年份，getYear() 方法仅返回年份是NowYear-1900

 int now_month=nowDate.getMonth();
 //设置现在年变量和月变量

 String String_year=null;
 int month_int=0;
 JPanel paneYM=new JPanel();
 JPanel paneDay =new JPanel();
 
 //建立容器对象
 
 //构造函数主要实现
 //1.将年份，月份加入下拉栏中
 //2./在容器里添加各种变量
 //3.在容器里添加各种变量
 //4.设置日历模块容器的网格布局
 //5.布日历局
 //6.设置容器在窗口的布局
 
 public Calender(){
  super();
  for(int year=now_year-30;year<=now_year+30;year++){
   yearCom.addItem(year+"");
   //在开头建立的年份下拉列表，建立数字项
   //additem 方法在组合框或列表框中添加一个新数据项，并且可以指定数据项索引。
  
   
  }
  for(int i=1;i<13;i++){
   monthCom.addItem(i+"");
 //在开头建立的月份下拉列表，建立数字项
 //additem 方法在组合框或列表框中添加一个新数据项，并且可以指定数据项索引。
 
  }
  
//在容器里添加各种变量
  yearCom.setSelectedIndex(30);
  paneYM.add(yearCom);//添加年下拉栏
  paneYM.add(year_i);//添加年标签
  monthCom.setSelectedIndex(now_month);
  paneYM.add(monthCom);//添加月下拉栏
  paneYM.add(month_i);//添加月栏标签
  
  //下拉栏添加监听！
  monthCom.addActionListener( this);
  yearCom.addActionListener(this);
  
  //设置paneDay网格布局，(行数,列数,行间距,列间距));
  paneDay.setLayout(new GridLayout(7,7,10,10));
  
  //布日历局
  for(int i=0;i<49;i++){
   jlabelDay[i] =new JLabel("  ");
 //初始化
   paneDay.add(jlabelDay[i]);
  }
  this.setDay();
  //设置容器在窗口的布局
  this.setLayout(new BorderLayout());
  this.add(paneDay,BorderLayout.CENTER);
//设置边界布局，设置在中心
  this.add(paneYM,BorderLayout.NORTH);
  this.setSize(100,200);
  //设置边界布局，北边
  this.setBorder(new TitledBorder("日历"));
  setSize(300,300);
 }
 //控制这个日历的几天几天 7*7的矩阵
 
 
 //设置日历中的日期
  void setDay() {
 
  String_year=yearCom.getSelectedItem().toString();
 //将此时的string类型在下拉列表去表达
   month_int=monthCom.getSelectedIndex();
  
  int year_sel=Integer.parseInt(String_year)-1900;
  
  //                    获得检索下拉列表里面的月份  日期为1号
  Date date= new Date(year_sel,month_int,1);
  GregorianCalendar cal=new GregorianCalendar();
  //获得年份值，月份值，
  cal.setTime(date);
  String[] week={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
  int day=0;
  int day_week=0;
  
  for(int i=0;i<7;i++){
	   jlabelDay[i].setText(week[i]);
	 }//显示日历开始一行标签
  
	  if(month_int==0||month_int==2||month_int==4||month_int==6||month_int==9||month_int==11){
		  //月份是从"0"开始的
		  //1 3 5 7 8 10 12 为大月
	   day=31;
	  }
	  else if(month_int==3||month_int==5||month_int==7||month_int==8||month_int==10){
		  		//2 4 6 
		     day=30;
	  			}else{
	  					if(cal.isLeapYear(year_sel)){
	  							// 调用GregorianCalendar类下 cal.isLeapYear 判断是否是闰年
	  							day=29;
	  					}else{
	  							day=28;
	  							}
	  				 }
	  
	  //设置大概布局，根据大概的年月来规划天数
	  
	  //得到现在这个月份的天数   用day来表示
	  
	  //去得到  day的数据进入下一个循环
	  
	  
	  day_week=7+date.getDay();
	  
	  /*
	  date.getDay(); 获取现在时间，如果是周日获取值为“0”，周一为“1”，~~周六为“6”
	  +7使用为 周1~周7里面有7个JFable[]
	    */
	  int count=1;
	  for(int i=day_week;i<day_week+day;count++,i++){
	   if(i %7==0||i==13||i==20||i==27||i==48||i==34||i==41){
		 //i%7==0 意思为现在是 周日变红色，其他周六变为red
	    if(i==day_week+nowDate.getDate()-1){
	    	
	    	//getDate()函数  返回本地时间1~31  但是-1相等于数组里面的i
	    	
	     jlabelDay[i].setForeground(Color.BLUE);
	     jlabelDay[i].setText(count+"*");       
	     //找出当前日期，并显示出蓝色
	    }else{
	     jlabelDay[i].setForeground(Color.RED);
	     jlabelDay[i].setText(count+"");        
	     //进入IF 不符合为
	     } }
	   else
	   {
	    if(i==day_week+nowDate.getDate()-1){
	     jlabelDay[i].setForeground(Color.BLUE);
	     jlabelDay[i].setText(count+"*");          
	//在当前日期上面添加 ' 使之加重显示
	    }else
	    {
	     jlabelDay[i].setForeground(Color.BLACK);
	     jlabelDay[i].setText(count+"");
	//else  在其他地方上加" "  意思是不加  里面为空
	    }
	   }
	   }
	  
	   
  	  
 	   
 		   for(int i=7;i<day_week;i++){
 			   	jlabelDay[i].setText(" ");         
 	    //在月份一号前面设为空“ ”
 	   }
 		   for(int i=day_week+day;i<49;i++){
 			   	jlabelDay[i].setText(" ");
 	   }//在月份日期最后一天加上“ ” 完成日历设置
 	  
 	  
 	   
 	   
 	 }//这个设置日历中的日期结束
 
  
	 public void actionPerformed(ActionEvent e) {
	//设置侦听器
	  if(e.getSource()==yearCom||e.getSource()==monthCom){
	   this.setDay();
	  }
	 }
	 
	}








