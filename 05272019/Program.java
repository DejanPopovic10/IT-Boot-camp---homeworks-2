package paket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Program {
	static long lastRequestTimestamp;

	public static enum Type {
		CURRENT, FORECAST
	};

	public static String getWeatherInfo(String city, String countryCode, Type type) throws IOException {
		String authToken = "d0f1969fd9856fe09e3f7d0753d84ed4";
		String addr = String.format("http://api.openweathermap.org/data/2.5/%s?q=%s,%s&appid=%s&units=metric",
				type == Type.CURRENT ? "weather" : "forecast", city, countryCode, authToken);
		if (System.currentTimeMillis() - lastRequestTimestamp < 5000) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		URLConnection yc = new URL(addr).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		StringBuilder buffer = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine);
		in.close();
		lastRequestTimestamp = System.currentTimeMillis();
		return buffer.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Dobrodošli u konzolnu vremensku prognozu!");
		System.out.println("----------------------------");

		String komande = "Komande:\r\n" + " -1) Izlaz iz programa\r\n" + "  0) Promena grada [String]\r\n"
				+ "  1) Trenutna temperatura\r\n" + "  2) Prognoza za 5 dana\r\n" + " 99) Ispis komandnog menija\r\n"
				+ "----------------------------";
		String grad = "Belgrade";
		String kod = "RS";
		int komanda = 0;
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		while (komanda != -1) {

			Scanner sc = new Scanner(System.in);
			System.out.print("komanda: ");
			komanda = sc.nextInt();

			switch (komanda) {
			case -1:
				break;
			case 0:
				String g = sc.next();
				String k = sc.next();
				grad = g;
				kod = k;
				break;
			case 1:

				String result;
				try {
					result = getWeatherInfo(grad, kod, Type.CURRENT);
					JSONParser parser = new JSONParser();
					obj = (JSONObject) parser.parse(result);
					obj = (JSONObject) obj.get("main");
					System.out.println("Trenutna: " + obj.get("temp") + "°C");
					System.out.println("Maksimalna: " + obj.get("temp_max") + "°C");
					System.out.println("Minimalna: " + obj.get("temp_min") + "°C");
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:

				try {
					result = getWeatherInfo(grad, kod, Type.FORECAST);
					JSONParser parser = new JSONParser();
					obj = (JSONObject) parser.parse(result);
					array = (JSONArray) obj.get("list");

					Calendar calendar = Calendar.getInstance();

					String[] dani = { "Ned", "Pon", "Uto", "Sre", "Čet", "Pet", "Sub" };

					for (int i = 0; i < array.size(); i += 8) {
						calendar.add(Calendar.DATE, 1);
						int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
						String dan = dani[index];
						obj = (JSONObject) array.get(i);
						obj = (JSONObject) obj.get("main");

						System.out.println(dan + ": " + obj.get("temp") + "°C");
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 99:
				System.out.println(komande);
				break;

			}
		}
	}
}
