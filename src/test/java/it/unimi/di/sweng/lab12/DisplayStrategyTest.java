package it.unimi.di.sweng.lab12;

import it.unimi.di.sweng.lab12.presenter.BoughtStrategy;
import it.unimi.di.sweng.lab12.presenter.DisplayStrategy;
import it.unimi.di.sweng.lab12.presenter.ToBuyStrategy;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DisplayStrategyTest {

    @Test
    public void toBuyStrategyTest() {
        Observable observable = mock(Observable.class);
        DisplayStrategy SUT = new ToBuyStrategy();

        Map<String, Integer> map = Map.of("pere", 5, "mele", 2);
        when(observable.getShoppingList()).thenReturn(map);

        assertThat(SUT.getData(observable)).isEqualTo(map);
    }

    @Test
    public void boughtStrategyTest() {
        Observable observable = mock(Observable.class);
        DisplayStrategy SUT = new BoughtStrategy();

        Map<String, Integer> map = Map.of("pere", 5, "mele", 2);
        when(observable.getBoughtList()).thenReturn(map);

        assertThat(SUT.getData(observable)).isEqualTo(map);
    }


}
