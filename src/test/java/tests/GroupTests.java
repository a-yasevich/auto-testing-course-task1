package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectClasses;
import tests.GroupAdditionTest;
import tests.PopularGroupsAdditionTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({GroupAdditionTest.class, PopularGroupsAdditionTest.class})
public class GroupTests {}
