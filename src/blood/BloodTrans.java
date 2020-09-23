package blood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BloodTrans {

	public static ArrayList<Model> donors = new ArrayList<Model>();
	public static ArrayList<Model> recipients = new ArrayList<Model>();

	public static String[] bloodGroup = { MyConstants.BLOOD_O_NEGATIVE, MyConstants.BLOOD_O_POSITIVE,
			MyConstants.BLOOD_A_NEGATIVE, MyConstants.BLOOD_A_POSITIVE, MyConstants.BLOOD_B_NEGATIVE,
			MyConstants.BLOOD_B_POSITIVE, MyConstants.BLOOD_AB_NEGATIVE, MyConstants.BLOOD_AB_POSITIVE };

	public static boolean bloodTransfusion[][] = new boolean[8][8];

	public static void main(String[] args) {

		try {
			readFromFile("donors.txt");
		} catch (IOException e) {
			System.err.println("donors.txt not found");
		}

		try {
			readFromFile("recipients.txt");
		} catch (IOException e) {
			System.err.println("recipients.txt not found");
		}

		prepareBloodFusionTable();

		System.out.println("");

		printBloodFusionTable();

		System.out.println("");

		ArrayList<Boolean[]> donorsFusionArray = new ArrayList<>();
		for (int a = 0; a < bloodTransfusion[0].length; a++) {
			System.out.println("");
			Boolean[] blood = new Boolean[8];
			for (int b = 0; b < bloodTransfusion[1].length; b++) {
				System.out.println("From " + bloodGroup[a] + " to " + bloodGroup[b] + " " + bloodTransfusion[a][b]);
				blood[b] = bloodTransfusion[a][b];
			}
			donorsFusionArray.add(blood);
		}

		for (int a = 0; a < donors.size(); a++) {
			String type = donors.get(a).bloodType;

			switch (type) {

			case MyConstants.BLOOD_O_NEGATIVE:

				System.out.println(
						MyConstants.BLOOD_O_NEGATIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(0)));
				
				break;
			case MyConstants.BLOOD_O_POSITIVE:
				System.out.println(
						MyConstants.BLOOD_O_POSITIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(1)));

				break;
			case MyConstants.BLOOD_A_NEGATIVE:
				System.out.println(
						MyConstants.BLOOD_A_NEGATIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(2)));

				break;
			case MyConstants.BLOOD_A_POSITIVE:
				System.out.println(
						MyConstants.BLOOD_A_POSITIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(3)));

				break;
			case MyConstants.BLOOD_B_NEGATIVE:
				System.out.println(
						MyConstants.BLOOD_B_NEGATIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(4)));
				break;
			case MyConstants.BLOOD_B_POSITIVE:
				System.out.println(
						MyConstants.BLOOD_B_POSITIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(5)));

				break;
			case MyConstants.BLOOD_AB_NEGATIVE:
				System.out.println(
						MyConstants.BLOOD_AB_NEGATIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(6)));

				break;
			case MyConstants.BLOOD_AB_POSITIVE:
				System.out.println(
						MyConstants.BLOOD_AB_POSITIVE + ", Available types " + Arrays.toString(donorsFusionArray.get(7)));

				break;

			default:

			}
		}
	}

	private static void printBloodFusionTable() {
		System.out.print("--------Blood Transfusion Table--------");
		for (int a = 0; a < bloodTransfusion[0].length; a++) {
			System.out.println("");
			for (int b = 0; b < bloodTransfusion[1].length; b++) {
				System.out.print(bloodTransfusion[a][b] + "\t");
			}
		}
	}

	private static void prepareBloodFusionTable() {
		bloodTransfusion[0][0] = true;
		bloodTransfusion[1][0] = true;
		bloodTransfusion[2][0] = true;
		bloodTransfusion[3][0] = true;
		bloodTransfusion[4][0] = true;
		bloodTransfusion[5][0] = true;
		bloodTransfusion[6][0] = true;
		bloodTransfusion[7][0] = true;

		bloodTransfusion[0][1] = false;
		bloodTransfusion[1][1] = true;
		bloodTransfusion[2][1] = false;
		bloodTransfusion[3][1] = true;
		bloodTransfusion[4][1] = false;
		bloodTransfusion[5][1] = true;
		bloodTransfusion[6][1] = false;
		bloodTransfusion[7][1] = true;

		bloodTransfusion[0][2] = false;
		bloodTransfusion[1][2] = false;
		bloodTransfusion[2][2] = true;
		bloodTransfusion[3][2] = true;
		bloodTransfusion[4][2] = false;
		bloodTransfusion[5][2] = false;
		bloodTransfusion[6][2] = true;
		bloodTransfusion[7][2] = true;

		bloodTransfusion[0][3] = false;
		bloodTransfusion[1][3] = false;
		bloodTransfusion[2][3] = false;
		bloodTransfusion[3][3] = true;
		bloodTransfusion[4][3] = false;
		bloodTransfusion[5][3] = false;
		bloodTransfusion[6][3] = false;
		bloodTransfusion[7][3] = true;

		bloodTransfusion[0][4] = false;
		bloodTransfusion[1][4] = false;
		bloodTransfusion[2][4] = false;
		bloodTransfusion[3][4] = false;
		bloodTransfusion[4][4] = true;
		bloodTransfusion[5][4] = true;
		bloodTransfusion[6][4] = true;
		bloodTransfusion[7][4] = true;

		bloodTransfusion[0][5] = false;
		bloodTransfusion[1][5] = false;
		bloodTransfusion[2][5] = false;
		bloodTransfusion[3][5] = false;
		bloodTransfusion[4][5] = false;
		bloodTransfusion[5][5] = true;
		bloodTransfusion[6][5] = false;
		bloodTransfusion[7][5] = true;

		bloodTransfusion[0][6] = false;
		bloodTransfusion[1][6] = false;
		bloodTransfusion[2][6] = false;
		bloodTransfusion[3][6] = false;
		bloodTransfusion[4][6] = false;
		bloodTransfusion[5][6] = false;
		bloodTransfusion[6][6] = true;
		bloodTransfusion[7][6] = true;

		bloodTransfusion[0][7] = false;
		bloodTransfusion[1][7] = false;
		bloodTransfusion[2][7] = false;
		bloodTransfusion[3][7] = false;
		bloodTransfusion[4][7] = false;
		bloodTransfusion[5][7] = false;
		bloodTransfusion[6][7] = false;
		bloodTransfusion[7][7] = true;

	}

	public static void readFromFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder sb = new StringBuilder();
		System.out.println("----------" + filename + "----------");
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
			String[] arrOfStr = line.split(";");
			boolean contains = Arrays.asList(bloodGroup).contains(arrOfStr[1]);
			if (contains) {
				Model donor = new Model();
				System.out.print("Name: " + arrOfStr[0]);
				System.out.println(" Blood Type: " + arrOfStr[1]);
				donor.setName(arrOfStr[0]);
				donor.setBloodType(arrOfStr[1]);
				donors.add(donor);

			} else {
				System.err.println("Invalid blood type " + arrOfStr[1] + " for " + arrOfStr[0]);
			}

		}
		reader.close();
	}
}
