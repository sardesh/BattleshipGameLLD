package com.game.exception;

public class OutOfAreaException extends RuntimeException {
  public OutOfAreaException(String message) {
    super(message);
  }
}
