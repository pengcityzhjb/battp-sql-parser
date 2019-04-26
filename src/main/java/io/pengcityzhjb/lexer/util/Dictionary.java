package io.pengcityzhjb.lexer.util;

import io.pengcityzhjb.lexer.token.DefaultKeyword;
import io.pengcityzhjb.lexer.token.Keyword;
import io.pengcityzhjb.lexer.token.TokenType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public final class Dictionary {

    private static final int DICTIONARY_CAPACITY = 1 << 10;
    private final Map<String, Keyword> tokens = new HashMap<String, Keyword>(DICTIONARY_CAPACITY);

    public Dictionary(final Keyword... dialectKeywords) {
        fill0(dialectKeywords);
    }

    private void fill0(final Keyword... dialectKeywords) {
        for (DefaultKeyword each : DefaultKeyword.values()) {
            tokens.put(each.name(), each);
        }
        for (Keyword each : dialectKeywords) {
            tokens.put(each.toString(), each);
        }
    }

    TokenType findTokenType(final String literals, final TokenType defaultTokenType) {
        if (StringUtils.isEmpty(literals)) {
            return defaultTokenType;
        }
        String key = literals.toUpperCase();
        if (tokens.containsKey(key)) {
            return tokens.get(key);
        }
        return defaultTokenType;
    }

    TokenType findTokenType(final String literals) {
        if (StringUtils.isEmpty(literals)) {
            throw new IllegalArgumentException();
        }
        String key = literals.toUpperCase();
        if (tokens.containsKey(key)) {
            return tokens.get(key);
        }
        throw new IllegalArgumentException();
    }
}
