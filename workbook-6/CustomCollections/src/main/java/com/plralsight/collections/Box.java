package com.plralsight.collections;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> content;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void display(T content) {
        System.out.println(content);
    }

    public Box() {
        content = new ArrayList<>();
    }

    public void addContent(T c) {
        content.add(c);
    }

    public void printContent() {
        if (!content.isEmpty()) {
            System.out.println("Content is : ");
            for (T c : content) {
                System.out.println(c);
            }
        } else {
            System.out.println("No content.");
        }
    }
}
