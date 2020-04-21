package komendant.weather;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFrame extends JFrame {

    URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip=07055&appid=a7b6239e49fd13f9be40d247fae3d6c2&units=imperial");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    InputStream in = connection.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    Gson gson = new Gson();
    CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

    private JLabel place;
    private JLabel temperature;
    private JLabel main;
    private JTextField zipCode;

    public WeatherFrame() throws IOException {
        setSize(250, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "Weather");

        setLayout(new BorderLayout());
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
        place = new JLabel("     " + currentWeather.name);
        temperature = new JLabel("     " + currentWeather.main);
        main = new JLabel("     " + currentWeather.weather[0]);
        display.add(place);
        display.add(temperature);
        display.add(main);
        add(display, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JLabel zipLabel = new JLabel("Zip Code: ");
        zipCode = new JTextField();
        JButton enterZip = new JButton("Enter");
        enterZip.addActionListener(actionEvent -> {
            try {
                setZip();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        leftPanel.add(zipLabel);
        leftPanel.add(zipCode);
        leftPanel.add(enterZip);
        leftPanel.setSize(100, 100);
        add(leftPanel, BorderLayout.WEST);

    }

    private void setZip() throws IOException {
        String newZip = zipCode.getText();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip="+ newZip +"&appid=78da2384bfeb19e9d11f341d43bbb434&units=imperial");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);
        place.setText("     " + currentWeather.name);
        temperature.setText("     " + currentWeather.main);
        main.setText("     " + currentWeather.weather[0]);
        zipCode.setText("");
    }

    public static void main(String[] args) throws IOException {

        new WeatherFrame().setVisible(true);
    }

}