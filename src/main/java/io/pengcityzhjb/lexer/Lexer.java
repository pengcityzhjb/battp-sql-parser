package io.pengcityzhjb.lexer;

import io.pengcityzhjb.lexer.token.Assist;
import io.pengcityzhjb.lexer.token.Literals;
import io.pengcityzhjb.lexer.token.Symbol;
import io.pengcityzhjb.lexer.token.Token;
import io.pengcityzhjb.lexer.util.Dictionary;
import io.pengcityzhjb.lexer.util.LexerHelper;
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
        skipIgnoredToken();
        if (isVariableBegin()) {
            token = scanVariable();
        } else if (isIdentifierBegin()) {
            token = scanIdentifier();
        } else if (isNumberBegin()) {
            token = scanNumber();
        } else if (isSymbolBegin()) {
            token = scanSymbol();
        } else if (isStringBegin()) {
            token = scanString();
        } else if (isEnd()) {
            token = new Token(Assist.END, "", offset);
        } else {
            token = new Token(Assist.END, "", offset);
        }
    }

    private Token scanNumber() {
        return null;
    }

    private Token scanIdentifier() {
        return null;
    }

    private Token scanVariable() {
        return null;
    }

    private Token scanSymbol() {
        int mark = offset++;
        while (isSymbolBegin()) {
            offset++;
        }
        String literals = sqlText.substring(mark, offset);
        return new Token(Symbol.literalsOf(literals), literals, offset);
    }

    private Token scanString() {
        int mark = offset++;
        while ('\'' != sqlText.charAt(offset) && '\"' != sqlText.charAt(offset)) {
            offset++;
        }
        offset++;
        return new Token(Literals.STRING, sqlText.substring(mark, offset), offset);
    }

    private void skipIgnoredToken() {
        while (LexerHelper.isWhitespace(sqlText.charAt(offset))) {
            offset++;
        }
    }

    public boolean isEnd() {
        return offset >= sqlText.length();
    }

    public boolean isStringBegin() {
        return '\'' == sqlText.charAt(offset) || '\"' == sqlText.charAt(offset);
    }

    public boolean isSymbolBegin() {
        char ch = sqlText.charAt(offset);
        return '(' == ch || ')' == ch || '[' == ch || ']' == ch || '{' == ch || '}' == ch
                || '+' == ch || '-' == ch || '*' == ch || '/' == ch || '%' == ch || '^' == ch || '=' == ch
                || '>' == ch || '<' == ch || '~' == ch || '!' == ch || '?' == ch || '&' == ch || '|' == ch
                || '.' == ch || ':' == ch || '#' == ch || ',' == ch || ';' == ch;
    }

    public boolean isVariableBegin() {
        //TODO
        return false;
    }

    public boolean isIdentifierBegin() {
        //TODO
        return false;
    }

    public boolean isNumberBegin() {
        //TODO
        return false;
    }
}