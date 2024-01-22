package it.unimi.di.sweng.lab12;

import it.unimi.di.sweng.lab12.presenter.InputPresenter;
import it.unimi.di.sweng.lab12.presenter.FormPresenter;
import it.unimi.di.sweng.lab12.view.InputView;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FormPresenterTest {

    @Test
    public void testInputAction() {
        Model model = mock(Model.class);
        InputView view = mock(InputView.class);
        InputPresenter SUT = new FormPresenter(model, view);

        SUT.action(4, "mele");
        verify(model).addItem("mele",4);
    }

}
