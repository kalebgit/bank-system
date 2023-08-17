package app;
import util.FileManager;
public class App {
	public static void main(String[] args) {
		String fileName = "prueba.txt";
		
//		FileManager.createFile(fileName);
//		FileManager.writeFile("prueba.txt", "hola desde java");
//		FileManager.addInfoFile(fileName, " mi nombre es Emiliano");
		FileManager.readFile(fileName);
		
	}
}
