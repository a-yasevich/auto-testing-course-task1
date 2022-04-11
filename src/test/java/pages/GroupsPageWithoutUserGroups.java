package pages;

import utils.GroupItem;

import java.util.List;

public class GroupsPageWithoutUserGroups extends AbstractGroupsPage {

    @Override
    public GroupsPageWithoutUserGroups clearGroups() {
        return this;
    }

    @Override
    public GroupsPageWithUserGroups fillListWithJoinedGroups(List<GroupItem> groups) {
        throw new UnsupportedOperationException("This page does not contain user's groups block");
    }
}
