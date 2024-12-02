package com.pluralsight;

import java.time.LocalDate;

public class Film {
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private double length;

    public Film(int filmId, String title, String description, int releaseYear, double length) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    public String toStringMovies() {
        return String.format("%-10s %-35s %-60s %-4s %-10s", filmId, title, description, releaseYear, length);
    }
}
