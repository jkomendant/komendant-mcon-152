package komendant.weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import javax.swing.*;
import java.awt.*;

public class WeatherFrame extends JFrame {

    private JLabel place;
    private JLabel temperature;
    private JLabel main;
    private JTextField zipCode;


    public WeatherFrame() {
        setSize(250, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "Weather");

        setLayout(new BorderLayout());
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
        place = new JLabel();
        temperature = new JLabel();
        main = new JLabel();
        display.add(place);
        display.add(temperature);
        display.add(main);
        add(display, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JLabel zipLabel = new JLabel("Zip Code: ");
        zipCode = new JTextField();
        JButton enterZip = new JButton("Enter");
        enterZip.addActionListener(actionEvent -> setZip());
        leftPanel.add(zipLabel);
        leftPanel.add(zipCode);
        leftPanel.add(enterZip);
        leftPanel.setSize(100, 100);
        add(leftPanel, BorderLayout.WEST);

    }

    private void setZip() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        service.getThisZip(zipCode.getText()).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                assert currentWeather != null;
                place.setText("     " + currentWeather.name);
                temperature.setText("     " + currentWeather.main);
                main.setText("     " + currentWeather.weather[0]);
                zipCode.setText("");

            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {

        new WeatherFrame().setVisible(true);
    }

}
