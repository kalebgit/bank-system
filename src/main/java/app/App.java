package app;
import java.io.*;

import util.FileManager;
public class App {
	public static void main(String[] args) {
//		String fileName = "prueba.txt";
		
//		FileManager.createFile(fileName);
//		FileManager.writeFile("prueba.txt", "hola desde java");
//		FileManager.addInfoFile(fileName, " mi nombre es Emiliano");
//		FileManager.readFile(fileName);
//		System.out.println();
		
//		File file = new File("prueba.txt");
		//			file.createNewFile();
//		System.out.println(file.canRead());
//		System.out.println(file.canWrite());
//		System.out.println(file.exists());
//		System.out.println(file.getName());
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.isFile());
//		System.out.println(file.isDirectory());
		
		
		// we create the bankOperations directory of log files
		File dir = new File("C:\\Users\\Usuario\\Documents\\Kaleb\\programacion\\java\\proyectos\\bank-system\\bankOperations");
//		if(dir.mkdir()) {
//			System.out.println("the directory has been created");
//		}else {
//			System.out.println("error");
//		}
//		
		File transactions = new File("bankOperations\\transanctions.txt");
		
//		try {
//			if(transactions.createNewFile()) {
//				System.out.println("the file has been created");
//			}else {
//				System.out.println("There has been an error while creating the file or its already there");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println(transactions.getAbsolutePath());
		File[] files = dir.listFiles();
//		System.out.println(dir.getAbsolutePath());
		System.out.println(files.length);
		for(File file : files) {
			System.out.println(file);
		}
		
	}
}

