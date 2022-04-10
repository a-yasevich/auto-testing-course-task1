package utils;

import java.util.Objects;

public class GroupItem {
    private final String name;
    public final String link;

    public GroupItem(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupItem groupItem = (GroupItem) o;
        return Objects.equals(name, groupItem.name) && Objects.equals(link, groupItem.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link);
    }

    @Override
    public String toString() {
        return "GroupItem{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
