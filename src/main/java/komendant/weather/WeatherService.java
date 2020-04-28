package komendant.weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("data/2.5/weather?appid=78da2384bfeb19e9d11f341d43bbb434&units=imperial")
    Call<CurrentWeather> getThisZip(@Query("zip") String newZip);
}
