package io.altar.jseproject.textinterface.states;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class CreateShelves extends State {
    private ShelfRepository DBS = ShelfRepository.getInstance();

    @Override
    public int on() {
        System.out.println("Criar prateleira");

        String localizacao = sc.getString("Insira a localização da prateleira");
        int capacity = sc.getInt("Insira a capacidade");
        double dailyPrice = sc.getDouble("Insira o preço diário");

        Shelf shelf = new Shelf(localizacao, capacity, dailyPrice);
        DBS.create(shelf);

        System.out.println("Prateleira criada com ID: " + shelf.getId());

        return 1;
    }
}
