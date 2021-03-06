package codingChallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class CountryCode {

	public static void main(String[] args) {

		// String csvFile =
		// "/Users/jinyongshin/Dropbox/DBFinal/national/list_of_leagues.csv";
		String csvFile = "/Users/jinyongshin/Desktop/Database_Final/FIFA_countrycode.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		// write in file
		BufferedWriter bw = null;
		try {
			String savedFile = "/Users/jinyongshin/Desktop/Database_Final/CountryCode.sql";
			File file = new File(savedFile);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(cvsSplitBy);
				String outputVal = "INSERT INTO CountryCode VALUES ('" + data[1] + "', \"" + data[0] + "\"); \n";
				bw.write(outputVal);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}