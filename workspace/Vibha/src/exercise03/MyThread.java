package exercise03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyThread extends Thread {
	Folder folder=new Folder();
	MyThread(Folder folder)
	{
		this.folder=folder;
	}
	
	public void run()
	{
	Exercise03 e03=new Exercise03(folder);
	e03.execute03();
	try {
		e03.writeOutput();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
