package com.vasquez.msclient.service.exception;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * Error response class.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Data
public class ErrorResponse {

  private LocalDateTime timestamp;
  private int code;
  private String error;
  private String message;

  /**
   * Error response constructor.
   *
   * @param code    code
   *
   * @param error   error
   *
   * @param message message
   */
  public ErrorResponse(int code, String error, String message) {
    this.timestamp = LocalDateTime.now();
    this.code = code;
    this.error = error;
    this.message = message;
  }

}
