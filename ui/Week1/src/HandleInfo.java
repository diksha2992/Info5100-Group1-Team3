import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class HandleInfo {
	 public static void addToFile(String filename,String content) throws FileNotFoundException
	   {
		   try{
		   FileWriter writer=new FileWriter(filename,true);
		   writer.write(content);
		   writer.close();
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
	   }//add new incentive to the file
	 
	 public static Incentive findRecord(String id)
	   {
		   try
		   {
			   Incentive r=new Incentive();
			   FileInputStream fis=new FileInputStream("incentiveDetails.txt");
			   InputStreamReader isr=new InputStreamReader(fis);
			   BufferedReader br=new BufferedReader(isr);
			   StringBuilder sb=new StringBuilder();
			   String str;
			   boolean isFound=false;
			   while((str=br.readLine())!=null)
			   {
				   if(str.equals("Incentive:")&&br.readLine().equals(id))
				      isFound=true;
				   if(isFound)
					   sb.append(str+"\n");
			   }
			   String[] incentive=sb.toString().split("\n");
			   r.setId(incentive[1]);
			   r.setTitle(incentive[2]);
			   r.setDiscount(incentive[3]);
			   r.setDiscount(incentive[4]);
			   r.setDescription(incentive[5]);
			   return r;
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
	 
	 public static ArrayList<Incentive> readFromFile(String fileName,int i) throws IOException
	 {
		 File file=new File(fileName); 
		 FileInputStream fis=new FileInputStream(file);
		 InputStreamReader isr=new InputStreamReader(fis);
		 BufferedReader br=new BufferedReader(isr);
		 StringBuilder sb=new StringBuilder();
		 ArrayList<Incentive> r=new ArrayList<Incentive>();
		 String temp;
		 int count=0;
		 while((temp=br.readLine())!=null&&count<=i)
		 {
			if(temp=="Incentive:")
			{
				count++;
				Incentive mid = null;
				mid.setId(br.readLine());
				mid.setTitle(br.readLine());
				mid.setDiscount(br.readLine());
				mid.setDescription(br.readLine());
				mid.setDisclaimer(br.readLine());
				r.add(mid);
			}
		 }
		 fis.close();
		 return r;
	 }
	 
	 public static void edit(String fileName,Incentive i)
	 {
		 File file=new File(fileName);
		 String id=i.getId();
		 try
		 {
			 StringBuilder res = new StringBuilder();
			 FileReader reader = new FileReader(file);
			 BufferedReader br = new BufferedReader(reader);
			 boolean addNewLine=false;
			 while(true)
			 {
				 String line=br.readLine();
				 if(line==null)
					 break;
				 if(line.equals(id))
				 {
					 res.append(id+"\n");
					 line=br.readLine();
					 res.append(i.getTitle()+"\n");
					 line=br.readLine();
					 res.append(i.getDiscount()+"\n");
					 line=br.readLine();
					 res.append(i.getDescription()+"\n");
					 line=br.readLine();
					 res.append(i.getDisclaimer());
					 line=br.readLine();
				 }
				 if(addNewLine)
					 res.append("\n");
				 else
					 addNewLine=true;
				 res.append(line);
			 }
			 br.close();
			 reader.close();
			 FileWriter writer = new FileWriter(file);
			 PrintWriter pw = new PrintWriter(writer);
			 pw.println(res.toString());
			 pw.close();
			 writer.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	 public void delete(String id)
	 {
		 File file=new File("incentiveDetails.txt");
		 try
		 {
			 StringBuilder res = new StringBuilder();
			 FileReader reader = new FileReader(file);
			 BufferedReader br = new BufferedReader(reader);
			 boolean addNewLine=false;
			 while(true)
			 {
				 String line=br.readLine();
				 if(line==null)
					 break;
				 if(line.equals(id))
				 {
					 for(int i=0;i<6;i++)
						 line=br.readLine();
				 }
				 if(addNewLine)
					 res.append("\n");
				 else
					 addNewLine=true;
				 res.append(line);
			 }
			 br.close();
			 reader.close();
			 FileWriter writer = new FileWriter(file);
			 PrintWriter pw = new PrintWriter(writer);
			 pw.println(res.toString());
			 pw.close();
			 writer.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
}
