package com.sitnikovasj.app.stateMashineLexer;

import java.util.ArrayList;

public class CommandPostpone implements ICommand {
    private ArrayList<Character> postponed;

    @Override
    public void execute(char currentSymbol, Context context) {
        postponed.add(currentSymbol);
        context = new Context(postponed);
    }
}

