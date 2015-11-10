package pl.wojtun.cfmxcompat.coder;


import org.apache.commons.codec.binary.Base64;

/**
 * Util class to handle Base 64 Encoded Strings
 */
public final class Base64Coder {


  /**
   * encodes a byte array to Base64 String
   * @param barr byte array to encode
   * @return encoded String
   */
  public static String encode(byte[] barr)  {
    barr=Base64.encodeBase64(barr);
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<barr.length;i++) {
      sb.append((char)barr[i]);
    }
    return sb.toString();
  }

  /**
   * decodes a Base64 String to a Plain String
   * @param encoded
   * @return decoded binary data
   * @throws CoderException
   */
  public static byte[] decode(String encoded) throws CoderException {
    try {
      char[] chars = encoded.toCharArray();
      byte[] bytes=new byte[chars.length];

      for(int i=0;i<chars.length;i++) {
        bytes[i]=(byte)chars[i];
      }
      return Base64.decodeBase64(bytes);
    }
    catch(Throwable t) {
      throw new CoderException("can't decode input ["+encoded+"]");
    }
  }
}
