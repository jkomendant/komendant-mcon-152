package komendant.earthquakes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.io.IOException;


public class GetCurrentEarthquakes {

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://earthquake.usgs.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EarthquakeService service = retrofit.create(EarthquakeService.class);

        service.getThisMonth().enqueue(new Callback<CurrentEarthquakes>() {
            @Override
            public void onResponse(Call<CurrentEarthquakes> call, Response<CurrentEarthquakes> response) {
                CurrentEarthquakes currentEarthquakes = response.body();
                for (CurrentEarthquakes.Feature feature: currentEarthquakes.features) {
                    System.out.println(feature.properties.toString());
                }
            }

            @Override
            public void onFailure(Call<CurrentEarthquakes> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}