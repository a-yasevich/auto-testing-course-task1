package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import utils.GroupItem;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class PopularGroupsList {
    private final static By POPULAR_GROUPS_LIST = By.xpath("//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]//*[@class = \"o group-name-link\"]");
    private final static By JOIN_POPULAR_GROUP_BUTTONS = By.xpath("//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]//*[@data-l = \"t,join\"]");

    public void joinPopularGroups(int groups){
        ElementsCollection joinButtons = $$(JOIN_POPULAR_GROUP_BUTTONS);
        for (int i = 0; i < groups; i++) {
            joinButtons.get(i).scrollIntoView(false).shouldBe(visible).click();
        }
    }
    public List<GroupItem> listOfPopularGroups(int groups){
        List<GroupItem> res = new ArrayList<>(groups);
        ElementsCollection popularGroups = $$(POPULAR_GROUPS_LIST);
        for (int i = 0; i < groups; i++) {
            String link = popularGroups.get(i).attr("href");
            String name = popularGroups.get(i).attr("title");
            res.add(new GroupItem(name, link));
        }
        return res;
    }
}
