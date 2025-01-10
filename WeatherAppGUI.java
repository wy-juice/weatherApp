import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author yulissamolina
 */
public class WeatherAppGUI extends javax.swing.JFrame {

        String[] imageNames =  {"blank.png","clear.png","clouds.png","drizzle.png","other.png","rain.png","snow.png", "thunderstorm.png", };
        String text;
    /**Creates new form NewWeatherApp*/
    public WeatherAppGUI() {
        initComponents();
    }


    
    
    // code for swing components                         
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(609, 694));
        jPanel1.setSize(new java.awt.Dimension(50, 50));

        jButton1.setText("Get Weather");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/yulissamolina/weatherapp/blank.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("");

        tf.setBackground(new java.awt.Color(51, 51, 51));
        tf.setForeground(new java.awt.Color(255, 255, 255));
        tf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter City in the US", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(403, 403, 403))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        pack();
    }
    //sets image based on weather description
    public void imageSelect() {

        if (text.contains("clear sky")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[1]);
            jLabel1.setIcon(iic);
        }
        else if (text.contains("null")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[1]);
            jLabel1.setIcon(iic);
        }
        else if (text.contains("thunderstorm")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[7]);
            jLabel1.setIcon(iic);
        }
        else if (text.contains("drizzle")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[3]);
            jLabel1.setIcon(iic);
        }
        else if (text.contains("rain")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[5]);
            jLabel1.setIcon(iic);
        }
        else if (text.contains("snow")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[6]);
            jLabel1.setIcon(iic);
        }
        else if (text.contains("clouds")) {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[2]);
            jLabel1.setIcon(iic);
        }
        else {
            ImageIcon iic = new javax.swing.ImageIcon(imageNames[4]);
            jLabel1.setIcon(iic);
        }

    }

    public void apiCall() {
        //api call to openwathermap.org
        try {
           // A try statement is used to catch exceptions that might be thrown as the
                // program executes.
                String wordInput = tf.getText(); //stores input form user
                URL url = new URL(
                        "https://api.openweathermap.org/data/2.5/weather?q=" + wordInput
                                + "&appid=e494eae3094628a9a9c6bd7d9d0c0171&units=imperial");// URL object from a string that
                                                                                            // stores our
                // website
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();// HttpURLConnection is used to make a
                                                                                     // connection to the URL.
                connect.setRequestMethod("GET");// Gets the connection from the API.
                connect.connect();// Calls to make the connection.

                int response = connect.getResponseCode();// Checks if the connection is made
                // Response code 200 means OK
                if (response != 200) {
                    jLabel2.setText("error: enter city");
                    jLabel3.setText("");
                    jLabel4.setText("");
                    jLabel1.setIcon(new javax.swing.ImageIcon("blank.png"));
                    throw new RuntimeException("HttpResponseCode: " + response); // throws this exception if an error occurs
                    
                   
                                                                                // while connecting the server.
                } else {

                    StringBuilder informationString = new StringBuilder();
                    Scanner input = new Scanner(url.openStream());

                    while (input.hasNext()) {
                        informationString.append(input.nextLine());
                        // System.out.println(informationString);//Prints out everything in the API
                    }
                    input.close();// closes scanner input.

                    JSONParser parse = new JSONParser();// parser for JSON text makes it easier to read JSON text.
                    JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));// JSON object
                                                                                                        // datatype for API.
                    String main = String.valueOf(dataObject.get("main"));// String data type to get main from API.
                    JSONObject mainObject = (JSONObject) parse.parse(String.valueOf(main));// Allows access to the main
                                                                                           // objects in API.
                    String name = String.valueOf(dataObject.get("name"));//String data type to get name from API.
                    System.out.println(name);
                    jLabel2.setText(name);// label1 shows name of city

                    String temp = String.valueOf(mainObject.get("temp"));// String data type to get temp from API.
                    // String humidity = String.valueOf(mainObject.get("humidity"));// String data type to get humidity in API.
                    int rTemp = Math.round(Float.valueOf(temp));// converts temp to a rounded int
                    System.out.println(rTemp);
                    jLabel3.setText(rTemp + "°F"); // label3 shows rounded temp 

                    JSONArray array = (JSONArray) dataObject.get("weather");//JSON array for brackets.
                    for (int y = 0; y < array.size(); y++) {
                        JSONObject weather = (JSONObject) array.get(y);// The for loop gets the first element in the array. Get the element from the weather json object. 
                        String description = (String) weather.get("description");//Gets the description value from the weather json object.
                        System.out.println("Description: " + description);
                        jLabel4.setText(description);//label4 shows description
                        text = description;
                        imageSelect();
                    }
                    
                }
            }
             catch (Exception e)// is used to handle the exception.
        {
            e.printStackTrace();
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //clicking enter shows weather
        //pulls data and sets textfield to blank
        apiCall();
        tf.setText("");

        
    }      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherAppGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherAppGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherAppGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherAppGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherAppGUI().setVisible(true);
            }
        });
    }
    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tf;                
}

