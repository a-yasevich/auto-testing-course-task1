package utils;

import java.util.Objects;

public class FeedItem {
    private final String text;
    private final String link;

    public FeedItem(String text, String groupName) {
        this.text = text;
        this.link = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedItem repost = (FeedItem) o;
        return link.equals(repost.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, link);
    }


    @Override
    public String toString() {
        return "text: " + text + "\nlink: " + link;
    }
}
