package io.pengcityzhjb.lexer.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Token {
    private final String literals;
    private final TokenType type;
    private final int endPos;
}
