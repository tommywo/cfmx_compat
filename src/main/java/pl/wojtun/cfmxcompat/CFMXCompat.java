package pl.wojtun.cfmxcompat;

import pl.wojtun.cfmxcompat.coder.Base64Coder;
import pl.wojtun.cfmxcompat.coder.CoderException;
import pl.wojtun.cfmxcompat.coder.HexCoder;
import pl.wojtun.cfmxcompat.coder.UUCoder;


public final class CFMXCompat {


  private static final String DEFAULT_ENCODING = "uu";
  private static final String UU = "uu";
  private static final String HEX = "hex";
  private static final String BASE64 = "base64";

  private CFMXCompat(){

  }

  public static String encrypt(String plain, String key) {
    return encrypt(plain,key,DEFAULT_ENCODING);
  }


  public static String decrypt(String encrypted, String key) throws CoderException {
    return decrypt(encrypted, key, DEFAULT_ENCODING);
  }


  public static String encrypt(String plain, String key, String encoding) {
    Transformer transformer = new Transformer();
    switch (encoding.toLowerCase()){
      case UU:
        return UUCoder.encode(transformer.transformString(key, plain.getBytes())).trim();
      case HEX:
        return HexCoder.encode(transformer.transformString(key, plain.getBytes())).trim();
      case BASE64:
        return Base64Coder.encode(transformer.transformString(key, plain.getBytes())).trim();
      default:
        return null;
    }
  }


  public static String decrypt(String encrypted, String key, String encoding) throws CoderException {
      Transformer transformer = new Transformer();
      switch (encoding.toLowerCase()) {
        case UU:
          return new String(transformer.transformString(key, UUCoder.decode(encrypted)));
        case HEX:
          return new String(transformer.transformString(key, HexCoder.decode(encrypted)));
        case BASE64:
          return new String(transformer.transformString(key, Base64Coder.decode(encrypted)));
        default:
          return null;
      }
  }

}
