package komendant.weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCurrentWeather {

    URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip=60645&appid=a7b6239e49fd13f9be40d247fae3d6c2");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    InputStream in = connection.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    Gson gson = new Gson();
    public CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

    public GetCurrentWeather() throws IOException {

    }
}
