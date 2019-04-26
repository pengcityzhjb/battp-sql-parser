package io.pengcityzhjb.lexer;

import io.pengcityzhjb.lexer.token.DefaultKeyword;
import io.pengcityzhjb.lexer.util.Dictionary;
import org.junit.Test;

public class LexerTest {

    @Test
    public void t1(){
        String sqlText = " select * from table t where t.id > 3 and t.name = 'a' limit 0,5 order by t.id;";
        Dictionary dic = new Dictionary(DefaultKeyword.values());
        Lexer lexer = new Lexer(sqlText, dic);
        lexer.nextToken();
        lexer.getToken();
    }
}
