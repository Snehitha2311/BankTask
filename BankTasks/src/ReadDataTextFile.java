import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadDataTextFile {

	public static void main(String[] args) throws Exception {

		List<String> account = Collections.emptyList();
		List<String> transactions = Collections.emptyList();
		List<String> data = new ArrayList();
		try {
			account = Files.readAllLines(Paths.get("C:\\Banktask\\bankaccount.txt"));
			transactions = Files.readAllLines(Paths.get("C:\\Banktask\\banktransactions.txt"));
			data.add("Name,Age,Gender,Bank,CardNumber,TransactionDate,Amount");
			for (String str : account) {
				String[] s = str.split(",");
				for (String str2 : transactions) {
					String[] s1 = str2.split(",");
					if (Objects.equals(s[4], s1[0])) {
						data.add(s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s1[1] + "," + s1[2]);
					}
				}
			}
			Files.write(Paths.get("C:\\Banktask\\bank.txt"), data);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the details:");
			String name = sc.nextLine();
			Path path = Paths.get("C:\\Banktask\\bank.txt");
			Files.lines(path).filter(str -> str.contains(name)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
