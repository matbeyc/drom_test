package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import selectors.FilterSelectors.ConstantFilterSelectors;
import utils.MarkList;

import java.util.*;

public class FilterElement extends BasePage {


    public void displayTopSoldMark(Integer topBorder) {
        MarkList markList = new MarkList(getAllMarkElements());
        markList.sortDesc();
        markList.display(topBorder);
    }

    private List<WebElement> getAllMarkElements() {
        Select select = new Select(driver.findElement(ConstantFilterSelectors.SELECT_MARK_DROPDOWN));
        return select.getOptions();
    }
}
