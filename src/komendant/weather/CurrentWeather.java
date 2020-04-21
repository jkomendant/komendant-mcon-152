package komendant.weather;

public class CurrentWeather {

    String base;
    int visibility;
    Coord coord;
    String name;
    Main main;
    Weather weather[];

    class Coord {
        double lon;
        double lat;
    }
    class Main {
        double temp;
        double feels_like;

        @Override
        public String toString() {
            return  temp + " degrees";
        }
    }
    class Weather {
        int id;
        String main;
        String description;
        String icon;

        @Override
        public String toString() {
            return  main + ": " +  description;
        }
    }
}