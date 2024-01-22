package it.unimi.di.sweng.lab12;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ModelTest {

    @Test
    public void testAddItem() {
        Model SUT = new Model();

        SUT.addItem("pere", 5);
        SUT.addItem("mele", 2);
        SUT.addItem("arance", 3);

        assertThat(SUT.getShoppingList()).containsEntry("pere", 5);
        assertThat(SUT.getShoppingList()).containsEntry("mele", 2);
        assertThat(SUT.getShoppingList()).containsEntry("arance", 3);
    }

    @Test
    public void testAddSameItemTwice() {
        Model SUT = new Model();

        SUT.addItem("pere", 5);
        SUT.addItem("pere", 5);
        assertThat(SUT.getShoppingList()).containsEntry("pere", 10);
    }

    @Test
    public void testBuyItem() {
        Model SUT = new Model();

        SUT.addItem("pere", 5);
        SUT.addItem("mele", 2);
        SUT.addItem("arance", 3);

        SUT.buy("pere");
        SUT.buy("mele");
        SUT.buy("mele");

        assertThat(SUT.getShoppingList()).containsEntry("pere", 4);
        assertThat(SUT.getShoppingList()).doesNotContainKey("mele");
        assertThat(SUT.getShoppingList()).containsEntry("arance", 3);
    }

    @Test
    public void testBoughtItem() {
        Model SUT = new Model();

        SUT.addItem("pere", 5);
        SUT.addItem("mele", 2);
        SUT.addItem("arance", 3);

        SUT.buy("pere");
        SUT.buy("mele");
        SUT.buy("mele");

        assertThat(SUT.getBoughtList()).containsEntry("pere", 1);
        assertThat(SUT.getBoughtList()).containsEntry("mele", 2);
        assertThat(SUT.getBoughtList()).doesNotContainKey("arance");
    }

    @Test
    public void testNotifyObservers() {
        Observable SUT = new Model();

        Observer obs1 = mock(Observer.class);
        Observer obs2 = mock(Observer.class);

        SUT.addObserver(obs1);
        SUT.addObserver(obs2);
        SUT.notifyObservers();

        verify(obs1).update(SUT);
        verify(obs2).update(SUT);
    }

}
