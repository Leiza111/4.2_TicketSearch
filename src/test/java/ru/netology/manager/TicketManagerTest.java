package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 7000, "VKO", "АНА", 180);
    private Ticket second = new Ticket(2, 8000, "KZN", "MMK", 180);
    private Ticket third = new Ticket(3, 6800, "VKO", "АНА", 160);
    private Ticket fourth = new Ticket(4, 4700, "SVO", "NOJ", 180);
    private Ticket fifth = new Ticket(5, 14000, "VKO", "АНА", 120);
    private Ticket sixth = new Ticket(6, 8900, "OHO", "UYG", 120);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldSortingSameDirection() { //сортировка по одинаковому направлению
        Ticket[] expected = new Ticket[]{first, third, fifth};
        Ticket[] actual = manager.searchBy("VKO", "АНА");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSingleDirection() { //искать единичное направление
        Ticket[] expected = new Ticket[]{sixth};
        Ticket[] actual = manager.searchBy("OHO", "UYG");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForNonexistentArray() { //несуществующее направление
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchBy("HYT", "YTR");
        assertArrayEquals(expected, actual);
    }

  }