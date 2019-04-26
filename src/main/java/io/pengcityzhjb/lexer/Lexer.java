package io.pengcityzhjb.lexer;

import io.pengcityzhjb.lexer.token.Token;
import io.pengcityzhjb.lexer.util.Dictionary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Lexer {

    private final String sqlText;
    private final Dictionary dictionary;

    private int offset;
    @Getter
    private Token token;

    public final void nextToken() {


    }
}
