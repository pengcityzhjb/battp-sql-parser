package io.pengcityzhjb.lexer.dialect;

import io.pengcityzhjb.lexer.Lexer;
import io.pengcityzhjb.lexer.util.Dictionary;

public class MySQLLexer extends Lexer {

    private static Dictionary dictionary = new Dictionary(MySQLKeyword.values());

    public MySQLLexer(final String sqlText) {
        super(sqlText, dictionary);
    }
}
