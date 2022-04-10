package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GroupAdditionTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"VK образование"})
    public void addGroups(String groupName) {
        mainPage.openGroupsPage()
                .findGroup(groupName)
                .joinGroup();

    }
}
