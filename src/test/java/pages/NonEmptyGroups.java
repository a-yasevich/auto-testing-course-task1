package pages;

import pages.elements.UserGroupsList;
import utils.GroupItem;

import java.util.List;

public class NonEmptyGroups extends AbstractGroupsPage {
    private final UserGroupsList userGroupList = new UserGroupsList();

    @Override
    public EmptyGroups clearGroups() {
        userGroupList.clearGroups();
        return new EmptyGroups();
    }

    @Override
    public NonEmptyGroups fillListWithJoinedGroups(List<GroupItem> groups) {
        groups.addAll(userGroupList.userGroupsList());
        return this;
    }
}
