package app;
import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

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
//		File dir = new File("C:\\Users\\Usuario\\Documents\\Kaleb\\programacion\\java\\proyectos\\bank-system\\bankOperations");
//		if(dir.mkdir()) {
//			System.out.println("the directory has been created");
//		}else {
//			System.out.println("error");
//		}
//		
//		File transactions = new File("bankOperations\\transanctions.txt");
		
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
//		File[] files = dir.listFiles();
//		System.out.println(dir.getAbsolutePath());
//		System.out.println(files.length);
//		for(File file : files) {
//			System.out.println(file);
//		}
		
		
//		File props = new File("db.properties");
//		try {
//			props.createNewFile();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try(BufferedWriter input = new BufferedWriter(new FileWriter("db.properties"))){
//			input.write("usuario=emi");
//			input.newLine();
//			input.write("contrasenia=emi2005");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		Properties p = new Properties();
//		try {
//			p.load(new FileReader(new File("db.properties")));
//			System.out.println(p.stringPropertyNames());
//			String usuario = p.getProperty("usuario");
//			String password = p.getProperty("contrasenia");
//			
//			System.out.println("El usuario es " + usuario + " y su contransenia es " + password);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		File databaseInfo = new File("database.properties");
		try {
			databaseInfo.createNewFile();
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(databaseInfo))){
				String hostname = "localhost";
				String sqlInstanceName = "DESKTOP-GT949E0\\SQLEXPRESS";
				String sqlDataBase = "AdventureWorks2022";
				String sqlUser = "sa";
				String sqlPassword = "emi";
				writer.write("hostName=" + hostname);
				writer.newLine();
				writer.write("sqlInstance=" + sqlInstanceName);
				writer.newLine();
				writer.write("sqlDataBase=" + sqlDataBase);
				writer.newLine();
				writer.write("sqlUser=" + sqlUser);
				writer.newLine();
				writer.write("sqlPassword=" + sqlPassword);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static <K, V> void createPropertiesFile(String fileName, Map<K, V> properties) {
		File file = new File("./" + fileName);
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			for(Entry<K, V> data : properties.entrySet()) {
				writer.write(data.getKey() + "=" + data.getValue());
				writer.newLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


