package com.nortal.assignment.mazeprovider;

/**
 * Created by Joosep Lall.
 */
public class LockedOutException extends RuntimeException {
    public LockedOutException() {
        super();
    }

    public LockedOutException(String str) {
        super(str);
    }
}
