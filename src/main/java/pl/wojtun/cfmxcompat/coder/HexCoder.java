package pl.wojtun.cfmxcompat.coder;

import java.nio.charset.StandardCharsets;

/**
 *
 */
public final class HexCoder {

  private static final String empty = "can't decode empty String";
  private static final String invalid = "invalid hexadicimal String";

  private HexCoder() {
  }

  /**
   * encodes a byte array to a String
   *
   * @return encoed String
   */
  public static String encode(byte[] bytes) {
    String retorno = "";
    if (bytes == null || bytes.length == 0) {
      return retorno;
    }
    for (int i = 0; i < bytes.length; i++) {
      byte valor = bytes[i];
      int d1 = valor & 0xF;
      d1 += (d1 < 10) ? 48 : 55;
      int d2 = (valor & 0xF0) >> 4;
      d2 += (d2 < 10) ? 48 : 55;
      retorno = retorno + (char) d2 + (char) d1;
    }
    return retorno;
  }

  /**
   * decodes back a String to a byte array
   *
   * @return decoded byte array
   */
  public static byte[] decode(String hexa) throws CoderException {
    if (hexa == null) {
      throw new CoderException(empty);
    }
    if ((hexa.length() % 2) != 0) {
      throw new CoderException(invalid);
    }
    int tamArray = hexa.length() / 2;
    byte[] retorno = new byte[tamArray];
    for (int i = 0; i < tamArray; i++) {
      retorno[i] = hexToByte(hexa.substring(i * 2, i * 2 + 2));
    }
    return retorno;
  }

  private static byte hexToByte(String hexa) throws CoderException {
    if (hexa == null) {
      throw new CoderException(empty);
    }
    if (hexa.length() != 2) {
      throw new CoderException(invalid);
    }
    byte[] b = hexa.getBytes(StandardCharsets.UTF_8);
    return (byte) (hexDigitValue((char) b[0]) * 16 +
                         hexDigitValue((char) b[1]));
  }

  private static int hexDigitValue(char c) throws CoderException {
    int retorno;
    if (c >= '0' && c <= '9') {
      retorno = ((byte) c) - 48;
    } else if (c >= 'A' && c <= 'F') {
      retorno = ((byte) c) - 55;
    } else if (c >= 'a' && c <= 'f') {
      retorno = ((byte) c) - 87;
    } else {
      throw new CoderException(invalid);
    }
    return retorno;
  }

}
