package com.example.movietheatreproj;

public class Movie {
    private final String title;
    private final String showtime;

    public Movie(String title, String showtime) {
        this.title = title;
        this.showtime = showtime;
    }
    public String getTitle() {
        return title;
    }

    public String getShowtime() {
        return showtime;
    }
}
