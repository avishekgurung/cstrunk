import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

class FilesOps{
	public static void main(String args[]) throws IOException{
		File file = new File("input.txt");
		if(!file.exists()){
			System.out.println("File does not exists");
			return;
		}

		BufferedReader bf = new BufferedReader(new FileReader(file));
		File output = new File("output.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		String line = "";
		while((line = bf.readLine()) != null){
			//System.out.println(line); //Process the line, any way u want
			bw.write(line);
			//bw.newLine();
		}

		bf.close();
		bw.close();
	}
}
