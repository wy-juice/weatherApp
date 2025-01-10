
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class weatherAPI {
    public static void main(String[] args) {
        try {
            try (// A try statement is used to catch exceptions that might be thrown as the
                 // program executes.
                    Scanner city = new Scanner(System.in)) {
                System.out.println("Enter a city : ");
                String wordInput = city.next();// String data type with city input.
                URL url = new URL(
                        "https://api.openweathermap.org/data/2.5/weather?q=" + wordInput
                                + "&appid=e494eae3094628a9a9c6bd7d9d0c0171&units=imperial");// URL object from a string
                                                                                            // that
                                                                                            // stores our
                // website
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();// HttpURLConnection is used to
                                                                                     // make a
                                                                                     // connection to the URL.
                connect.setRequestMethod("GET");// Gets the connection from the API.
                connect.connect();// Calls to make the connection.

                int response = connect.getResponseCode();// Checks if the connection is made
                // Response code 200 means OK
                if (response != 200) {
                    throw new RuntimeException("HttpResponseCode: " + response);// throws this exception if an error
                                                                                // occurs
                                                                                // while connecting the server.
                } else {

                    StringBuilder apiString = new StringBuilder();// represents mutable sequences of character for API.
                    Scanner input = new Scanner(url.openStream());// java.util.Scanner object for reading text contents
                                                                  // from the URL.

                    while (input.hasNextLine())// Returns true if there is another line in the input of this scanner.
                    {
                        apiString.append(input.nextLine());// StringBuilder class method used to append a value to the
                                                           // current sequence.
                        // System.out.println(informationString);//Prints out everything in the API
                    }
                    input.close();// closes scanner input.

                    JSONParser parse = new JSONParser();// parser for JSON text makes it easier to read JSON text.
                    JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(apiString));// JSON object
                                                                                                // datatype for API.
                    String main = String.valueOf(dataObject.get("main"));// String data type to get main from API.
                    JSONObject mainObject = (JSONObject) parse.parse(String.valueOf(main));// Allows access to the main
                                                                                           // objects in API.
                    String temp = String.valueOf(mainObject.get("temp"));// String data type to get temp from API.
                    // String humidity = String.valueOf(mainObject.get("humidity"));// String data
                    // type to get humidity in API.

                    System.out.println("Temperature: " + temp + "F");
                    // System.out.println(temp);

                    JSONArray array = (JSONArray) dataObject.get("weather");// JSON array for brackets.
                    for (int y = 0; y < array.size(); y++) {
                        JSONObject weather = (JSONObject) array.get(y);// The for loop gets the first element in the
                                                                       // array. Get the element from the weather json
                                                                       // object.
                        String description = (String) weather.get("description");// Gets the description value from the
                                                                                 // weather json object.
                        System.out.println("Description: " + description);
                    }

                }
            }
        } catch (Exception e)// is used to handle the exception.
        {
            e.printStackTrace();
        }
    }
}
// JSON(JavaScript Object Notation)
// Data representation format
// Used in APIs and Configs
// Integrates easily with most programming languages
