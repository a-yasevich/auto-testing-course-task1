package tests.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import tests.GroupAdditionTest;
import tests.PopularGroupsAdditionTest;

@Suite
@SelectClasses({GroupAdditionTest.class, PopularGroupsAdditionTest.class})
public class GroupTests {
}
