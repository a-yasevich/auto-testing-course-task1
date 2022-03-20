package com.example.autotestingcoursetask1;

import java.util.Objects;

public class Repost {
    private final String text;
    private final String link;

    public Repost(String text, String groupName) {
        this.text = text;
        this.link = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repost repost = (Repost) o;
        return text.equals(repost.text) && link.equals(repost.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, link);
    }
}
