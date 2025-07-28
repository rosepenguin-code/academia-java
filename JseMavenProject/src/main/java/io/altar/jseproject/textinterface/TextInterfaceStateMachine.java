package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.states.CreateProducts;
import io.altar.jseproject.textinterface.states.CreateShelves;
import io.altar.jseproject.textinterface.states.DeleteProducts;
import io.altar.jseproject.textinterface.states.DeleteShelves;
import io.altar.jseproject.textinterface.states.MenuInit;
import io.altar.jseproject.textinterface.states.MenuProducts;
import io.altar.jseproject.textinterface.states.MenuShelves;
import io.altar.jseproject.textinterface.states.ReadProducts;
import io.altar.jseproject.textinterface.states.ReadShelves;
import io.altar.jseproject.textinterface.states.State;
import io.altar.jseproject.textinterface.states.UpdateProducts;
import io.altar.jseproject.textinterface.states.UpdateShelves;

public class TextInterfaceStateMachine {
    // 2. states
    private State[] states = { 
        new MenuInit(),        // State 0
        new MenuProducts(),    // State 1
        new MenuShelves(),     // State 2
        new CreateShelves(),   // State 3
        new UpdateShelves(),   // State 4
        new ReadShelves(),     // State 5
        new DeleteShelves(),   // State 6
        new CreateProducts(),  // State 7
        new UpdateProducts(),  // State 8
        new ReadProducts(),    // State 9
        new DeleteProducts()   // State 10
    };

    // 4. transitions
    private int[][] transition = { 
        { 1, 2 },             // from MenuInit (0)
        { 7, 8, 9, 10, 0 },   // from MenuProducts (1)
        { 3, 4, 5, 6, 0 },    // from MenuShelves (2)
        { 2 },                // from CreateShelves (3)
        { 2 },                // from UpdateShelves (4)
        { 2 },                // from ReadShelves (5)
        { 2 },                // from DeleteShelves (6)
        { 1 },                // from CreateProducts (7)
        { 1 },                // from UpdateProducts (8)
        { 1 },                // from ReadProducts (9)
        { 1 }                 // from DeleteProducts (10)
    };

    // 3. current state index
    private int current = 0;

    // 5. All client requests are delegated to the current state object
    public void start() {
        while(true) {
            int option = states[current].on();
            if (current == 0 && option == 3) {
                System.out.println("Saída");
                break;
            }
            current = transition[current][option - 1];
        }
    }
}
