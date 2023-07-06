package ar.edu.unlam.tallerweb1.domain;
import java.util.List;

public class WeatherData {

    private String name;
    private int cod;
    private Long id;

    private List<Data> weather;

    private Main main;

    public WeatherData() {
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Data> getWeather() {
        return weather;
    }

    public void setWeather(List<Data> weather) {
        this.weather = weather;
    }

    public static class Main {
        private Double temp;
        private Double feels_like;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(Double feels_like) {
            this.feels_like = feels_like;
        }
    }


    public static class Data{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "name='" + name + '\'' +
                ", cod=" + cod +
                ", id=" + id +
                ", weather=" + weather +
                '}';
    }
}
