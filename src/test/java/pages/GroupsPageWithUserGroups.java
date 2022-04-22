package pages;

import pages.elements.UserGroupsList;
import utils.GroupItem;

import java.util.List;

public class GroupsPageWithUserGroups extends ContentGroupsPage {
    private final UserGroupsList userGroupList = new UserGroupsList();

    @Override
    public GroupsPageWithoutUserGroups clearGroups() {
        userGroupList.clearGroups();
        return new GroupsPageWithoutUserGroups();
    }

    @Override
    public GroupsPageWithUserGroups fillListWithJoinedGroups(List<GroupItem> groups) {
        groups.addAll(userGroupList.userGroupsList());
        return this;
    }

    @Override
    public void check() {

    }
}
