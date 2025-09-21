package com.somanathdevs.pawpalace.utils;

public class StringUtils {

    /**
     * Masks the last n characters of a string with the given mask character.
     *
     * @param input The original string
     * @param maskLength Number of characters to mask from the end
     * @param maskChar Character to use for masking
     * @return Masked string
     */
    public static String maskFromEnd(String input, int maskLength, char maskChar) {
        if (input == null || maskLength <= 0) {
            return input;
        }
        int length = input.length();
        if (maskLength >= length) {
            return input.replaceAll(".", String.valueOf(maskChar));
        }
        String visiblePart = input.substring(0, length - maskLength);
        String maskedPart = String.valueOf(maskChar).repeat(maskLength);
        return visiblePart + maskedPart;
    }

}
