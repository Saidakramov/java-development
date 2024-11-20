package com.plralsight.collections.streams;

public class Course implements Comparable<Course>{
    private String title;
    private int points;
    private int maxStudents;

    public Course(String title, int points, int maxStudents) {
        this.title = title;
        this.points = points;
        this.maxStudents = maxStudents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    @Override
    public int compareTo(Course o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", points=" + points +
                ", maxStudents=" + maxStudents +
                '}';
    }
}
