package it.unimi.di.sweng.lab12;

import it.unimi.di.sweng.lab12.presenter.CommandPresenter;
import it.unimi.di.sweng.lab12.presenter.InputPresenter;
import it.unimi.di.sweng.lab12.view.CommandView;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class CommandPresenterTest {

    @Test
    public void testBuyInputPresenter() {
        Model model = mock(Model.class);
        CommandView view = mock(CommandView.class);
        InputPresenter SUT = new CommandPresenter(model, view);

        SUT.action(0, "pere");

        verify(model).buy("pere");
    }

    @Test
    public void testUpdateObserver() {
        Model model = mock(Model.class);
        CommandView view = mock(CommandView.class);
        Observer SUT = new CommandPresenter(model, view);

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("pere", 5);
        items.put("mele", 2);
        when(model.getShoppingList()).thenReturn(items);

        SUT.update(model);
        verify(view).set(0, "pere");
        verify(view).set(1, "mele");

        for (int i = 2; i < Main.MAX_FOOD; i++) {
            verify(view).set(i, "---");
        }

    }

}
