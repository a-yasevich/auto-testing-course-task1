package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.GroupItem;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class AllMyGroups {
    private final static By GROUPS_LIST = By.xpath("//*[@id=\"listBlockPanelUserGroupsSectionBlock\"]//*[@class = \"group-vitrine-card_name\"]");

    public List<GroupItem> userGroupsList(int numberOfGroups) {
        List<GroupItem> res = new ArrayList<>(numberOfGroups);
        ElementsCollection elements = $$(GROUPS_LIST);
        for (int i = 0; i < numberOfGroups; i++) {
            SelenideElement group = elements.get(i);
            String link = group.attr("href");
            String name = group.text();
            res.add(new GroupItem(name, link));
        }
        return res;
    }
}
