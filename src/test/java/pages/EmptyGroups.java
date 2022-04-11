package pages;

import utils.GroupItem;

import java.util.List;

public class EmptyGroups extends AbstractGroupsPage {

    @Override
    public EmptyGroups clearGroups() {
        return this;
    }

    @Override
    public NonEmptyGroups fillListWithJoinedGroups(List<GroupItem> groups) {
        return new NonEmptyGroups();
    }
}
