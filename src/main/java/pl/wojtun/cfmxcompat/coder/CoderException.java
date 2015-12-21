package pl.wojtun.cfmxcompat.coder;

import java.io.IOException;


/**
 *
 */
public final class CoderException extends IOException {

  /**
   * @param message
   */
  public CoderException(String message) {
    super(message);
  }

  public CoderException(String message, Throwable cause) {
    super(message, cause);
  }
}
