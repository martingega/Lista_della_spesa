package it.unimi.di.sweng.lab12;

import it.unimi.di.sweng.lab12.presenter.DisplayPresenter;
import it.unimi.di.sweng.lab12.presenter.DisplayStrategy;
import it.unimi.di.sweng.lab12.view.DisplayView;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class DisplayPresenterTest {

    @Test
    public void testUpdateView() {
        Model model = mock(Model.class);
        DisplayView view = mock(DisplayView.class);
        DisplayStrategy strategy = mock(DisplayStrategy.class);
        DisplayPresenter SUT = new DisplayPresenter(model, view, strategy);

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("pere", 5);
        items.put("mele", 2);

        // Mocking di strategy banale ma così facendo l'unica classe 'concreta' è il SUT.
        // Non è necessario mockare metodi di model in quanto il presenter
        // si interfaccia con model attraverso la strategy.
        when(strategy.getData(model)).thenReturn(items);

        SUT.update(model);

        verify(view).set(0, "pere 5");
        verify(view).set(1, "mele 2");
        for (int i = 2; i < Main.MAX_FOOD; i++) {
            verify(view).set(i, "");
        }

    }

}
