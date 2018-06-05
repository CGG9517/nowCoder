package interveiw.c.s;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @Class: CharsetHelper
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/3
 */
public class CharsetHelper {
    private static final String UTF_8 = "UTF-8";
    private static CharsetEncoder encoder = Charset.forName("utf-8").newEncoder();
    private static CharsetDecoder decoder = Charset.forName("utf-8").newDecoder();


    public CharsetHelper() {
        throw new AssertionError();
    }

    public static CharBuffer decode(ByteBuffer buffer) throws CharacterCodingException {
        return decoder.decode(buffer);
    }

    public static ByteBuffer encode(CharBuffer wrap) throws CharacterCodingException {
        return encoder.encode(wrap);

    }
}
