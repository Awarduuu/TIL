package day04;

import java.util.*;

class  PrintfExam{
	public static void main(String[] args) {
		System.out.printf("%d%d%n",20,30);
		System.out.printf("%d , %d%n",20,30);
		System.out.println();
	   System.out.printf("���� : %,d��%n",25320000);
	   System.out.printf("%5.2f%n",35.33333);
	 System.out.println();
		 System.out.printf("%d��  %d�� %d��%n",2009,5,3);
		 System.out.printf("%2$d�� %3$d�� %1$d��%n",1, 2005, 3);

		Calendar now= new GregorianCalendar();
		System.out.println("\nYear=>"+now.get(Calendar.YEAR));
		System.out.println("month=>"+ (now.get(Calendar.MONTH)+1) );
		System.out.println("date=>"+now.get(Calendar.DATE) +"\n");
		
		//System.out.println(now);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� : %1$tM�� : %1$tS��%n" , now);
		System.out.println();
		System.out.printf("%3d %-10s %-8s %-5d%n",1,"jang","������",20);
		System.out.printf("%3d %-10s %-8s %-5d%n",22,"hee","��ȿ��",03);
		System.out.printf("%3d %-10s %-8s %-5d%n",3,"rew97","������",20);
		System.out.printf("%3d %-10s %-8s %-5d%n",4,"jang","������",20);
	}
}
