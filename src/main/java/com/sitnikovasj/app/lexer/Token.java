package com.sitnikovasj.app.lexer;

/**
 * the token contains the name and lexeme
 */
public final class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     *
     * @param name - the name of the token
     * @param lexeme - the lexeme of the token
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
