package exercise03;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exercise.Exercise;

public class Exercise03 extends Exercise{
	int numberOfTimes;
	String[] listOfFiles;
	Folder folder;
	String[] searchedFiles;
	public Exercise03()
	{
	}
	public Exercise03(Folder folder)
	{
		this.folder=folder;
	}
	@Override
	public void getInput()
	{
		System.out.println("Enter the number of times you want to enter the input- Max 10");
		Scanner scan=new Scanner(System.in);
		
		do
		{
			numberOfTimes=scan.nextInt();
			
		}while(numberOfTimes>10);
				 
		
	
}
	public static ArrayList listDetails(File file, ArrayList list)
	{
		for(File f: file.listFiles())
		{
		if(f.isDirectory())
		{
			list.add(f.getAbsolutePath());
			listDetails(f,list);
		}
		else
		{
		list.add(f.getAbsolutePath());	
		}
		}
		
		return list;
		
	}
	@Override
	public void execute()
	{
		//File sourceDirectory= new File("C:/Users/vjnanendra/Desktop/directory1");	
		//File destinationDirectory=new File("C:/Users/vjnanendra/Desktop/directory2");
		
		for(int count=0;count<numberOfTimes;count++)
		{
		
		folder=new Folder();
		folder.input();
		
		MyThread thread=new MyThread(folder);
		thread.start();
		}
	}
	public void execute03()
	{
		
	File sourceDirectory=folder.getSource();
	File destinationDirectory=folder.getDestination();
	
	folder.copyFolder(sourceDirectory,destinationDirectory);
	long start=System.currentTimeMillis();
	long end=start+100;
	while(System.currentTimeMillis()<end)
	{
		
	}
	ArrayList<String> list=new ArrayList<>();
	list=listDetails(destinationDirectory,list);
	listOfFiles=list.toArray(new String[0]);
	

	}
	public void listSearchedFiles() throws IOException
	{
		String searchItem=folder.getCharToSearch();
		BufferedReader read=new BufferedReader(new FileReader (folder.getResultFile().getAbsolutePath()));
		String line= null;
		//to skip heading name and border
		for(int i=0;i<4;i++)
		line=read.readLine();
		File temp=folder.getDestination();
		while((line=read.readLine())!=null)
		{
			line=line.substring(0, line.indexOf(' '));
			
			if(new File(line).isDirectory())
			{
				temp= new File(line);
			}
			if(line.startsWith(temp.getAbsolutePath()+"\\"+folder.getCharToSearch()))
			{
				System.out.println(line);
			}
		}
		read.close();
	}
	
		
	@Override
	public void writeOutput() throws IOException
	{
		write(folder.getResultFile(),"filename                                         size\r\n");
		write(folder.getResultFile(),"----------------------------------------------------------------\r\n");
		for(int i=0;i<listOfFiles.length;i++) {
			 
		    File file=new File(listOfFiles[i]); 
		    write(folder.getResultFile(),file.getAbsolutePath()+"          "+file.length()+"bytes"+"\r\n");
		    
		    }
		if(folder.getCharToSearch()!=null){
			listSearchedFiles();
		}
		  
	}
 
	

}
