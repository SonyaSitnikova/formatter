package com.sitnikovasj.app.stateMashineLexer;

public interface ICommandRepository {
    public ICommand getNextCommand(State state, String simbol);
}
