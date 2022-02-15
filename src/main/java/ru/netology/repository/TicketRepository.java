package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    //сохранение продуктов
    public void save(Ticket product) {
        // создаем новый массив на единицу больше
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        //копирование поэлементно
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        //кладем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        tickets = tmp;
    }
    // получение всех сохраненных продуктов
    public Ticket[] findAll() {
        return tickets;
    }

    //удаление по id
    public void removeById(int id) {
        int length = tickets.length-1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket product: tickets) {
            if (product.getId() !=id) {
                tmp[index] = product;
                index++;
            }
        }
        //меняеи наши элементы
        tickets = tmp;
    }
}
