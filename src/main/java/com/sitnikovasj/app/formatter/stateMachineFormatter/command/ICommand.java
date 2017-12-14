package com.sitnikovasj.app.formatter.stateMachineFormatter.command;

import com.sitnikovasj.app.formatter.stateMachineFormatter.Context;
import com.sitnikovasj.app.lexer.IToken;

/**
 *
 */
public interface ICommand {
    /**
     *
     * @param context c
     * @param token token
     */
    void execute(Context context, IToken token);
    /**
     *
     */
    void execute();
}
