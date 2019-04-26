package io.pengcityzhjb.lexer;

import io.pengcityzhjb.lexer.token.Token;
import io.pengcityzhjb.lexer.util.Dictionary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Lexer {

    private String sqlText;
    private int offset;
    private Dictionary dictionary;

    @Getter
    private Token token;

    public final void nextToken() {


    }
}
