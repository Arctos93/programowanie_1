package com.sda.cw_7;

import com.sda.cw_3.EmptyListException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class GenericListImplTest {

    @Test
    public void size_listIsEmptyWhenCreated() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        assertEquals(0, underTest.size());
    }

    @Test
    public void addFirst_listHasOneElementWhenAdded() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(999);

        assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0).longValue());
    }

    @Test
    public void addFirst_listHasTwoElementsWhenAddedTwo() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(999);
        underTest.addFirst(888);

        assertEquals(2, underTest.size());
        assertEquals(888, underTest.get(0).longValue());
        assertEquals(999, underTest.get(1).longValue());
    }

    @Test
    public void addLast_listHasOneElementWhenAdded() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);

        assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0).longValue());
    }

    @Test
    public void addLast_listHasTwoElementsWhenAddedTwo() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);
        underTest.addLast(888);

        assertEquals(2, underTest.size());
        assertEquals(999, underTest.get(0).longValue());
        assertEquals(888, underTest.get(1).longValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_throwsForIllegalIndex() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.add(999, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_throwsForIllegalIndexForNonEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();

        underTest.addFirst(888);
        underTest.add(999, 2);
    }

    @Test
    public void add_addsToHeadWhenEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.add(999, 0);

        assertEquals(1,  underTest.size());
        assertEquals(999,  underTest.get(0).longValue());
    }

    @Test
    public void add_addsToHeadWhenNotEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();

        underTest.addFirst(888);

        underTest.add(999, 0);

        assertEquals(2,  underTest.size());
        assertEquals(999,  underTest.get(0).longValue());
        assertEquals(888,  underTest.get(1).longValue());
    }

    @Test
    public void add_addsToTailWhenNotEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();

        underTest.addFirst(888);

        underTest.add(999, 1);

        assertEquals(2,  underTest.size());

        assertEquals(888,  underTest.get(0).longValue());
        assertEquals(999,  underTest.get(1).longValue());
    }

    @Test
    public void add_addsInTheMiddle() {
        GenericList<Integer> underTest = new GenericListImpl<>();

        underTest.addLast(111);
        underTest.addLast(222);
        underTest.addLast(333);

        underTest.add(223, 2);

        assertEquals(4, underTest.size());
        assertEquals(111, underTest.get(0).longValue());
        assertEquals(222, underTest.get(1).longValue());
        assertEquals(223, underTest.get(2).longValue());
        assertEquals(333, underTest.get(3).longValue());
    }

    @Test
    public void removeFirst_throwsWhenEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        Optional<Integer> value = underTest.removeFirst();
        assertFalse(value.isPresent());
    }

    @Test
    public void removeFirst_isEmptyAfterLastElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);

        Optional<Integer> value = underTest.removeFirst();

        assertTrue(value.isPresent());
        assertEquals(999, value.get().longValue());
        assertEquals(0, underTest.size());
    }

    @Test
    public void removeFirst_isNotEmptyAfterLastElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(777);
        underTest.addLast(888);
        underTest.addLast(999);

        Optional<Integer> value = underTest.removeFirst();

        assertTrue(value.isPresent());
        assertEquals(777, value.get().longValue());
        assertEquals(2, underTest.size());
        assertEquals(888, underTest.get(0).longValue());
        assertEquals(999, underTest.get(1).longValue());
    }

    @Test
    public void removeLast_throwsWhenEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        Optional<Integer> value = underTest.removeLast();

        assertFalse(value.isPresent());
    }

    @Test
    public void removeLast_isEmptyAfterLastElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);

        Optional<Integer> value = underTest.removeLast();

        assertTrue(value.isPresent());
        assertEquals(999, value.get().longValue());
        assertEquals(0, underTest.size());
    }

    @Test
    public void removeLast_isNotEmptyAfterLastElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(777);
        underTest.addLast(888);
        underTest.addLast(999);

        Optional<Integer> value = underTest.removeLast();

        assertTrue(value.isPresent());
        assertEquals(999, value.get().longValue());
        assertEquals(2, underTest.size());
        assertEquals(777, underTest.get(0).longValue());
        assertEquals(888, underTest.get(1).longValue());
    }

    @Test(expected = EmptyListException.class)
    public void remove_throwsWhenEmpty() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_throwsWhenNotExists() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(999);

        underTest.remove(1);
    }

    @Test
    public void remove_isEmptyAfterFirstElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);

        int value = underTest.remove(0);

        assertEquals(999, value);
        assertEquals(0, underTest.size());
    }

    @Test
    public void remove_isNotEmptyAfterFirstElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);
        underTest.addLast(888);

        int value = underTest.remove(0);

        assertEquals(999, value);
        assertEquals(1, underTest.size());
        assertEquals(888, underTest.get(0).longValue());
    }

    @Test
    public void remove_isNotEmptyAfterLastElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(999);
        underTest.addLast(888);

        int value = underTest.remove(1);

        assertEquals(888, value);
        assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0).longValue());
    }

    @Test
    public void remove_isNotEmptyAfterElementRemoved() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addLast(777);
        underTest.addLast(888);
        underTest.addLast(999);

        int value = underTest.remove(1);

        assertEquals(888, value);
        assertEquals(2, underTest.size());
        assertEquals(777, underTest.get(0).longValue());
        assertEquals(999, underTest.get(1).longValue());
    }

    @Test
    public void contains_returnsFalseForEmptyList() {
        GenericList<String> underTest = new GenericListImpl<>();
        assertFalse(underTest.contains("Ala ma kota"));
    }

    @Test
    public void contains_returnsFalseForOneElementListThatNotContains() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(888);
        assertFalse(underTest.contains(999));
    }

    @Test
    public void contains_returnsTrueForOneElementListThatContains() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(999);
        assertTrue(underTest.contains(999));
    }

    @Test
    public void contains_returnsFalseForMultiElementListThatNotContains() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(888);
        underTest.addFirst(777);
        underTest.addFirst(888);
        underTest.addFirst(444);

        assertFalse(underTest.contains(999));
    }

    @Test
    public void contains_returnsTrueForMultiElementListThatContains() {
        GenericList<Integer> underTest = new GenericListImpl<>();
        underTest.addFirst(888);
        underTest.addFirst(777);
        underTest.addFirst(444);
        underTest.addLast(999);

        assertTrue(underTest.contains(999));
    }

}