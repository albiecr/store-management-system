package com.model;

public class Validation {

    public static boolean validateCPF (String cpf) {
        
        if (cpf == null) return false;

         // Remove any non-digit characters
        cpf = cpf.replaceAll("[^\\d]", "");

        //Must be exactly 11 digits
        if (cpf.length() != 11) return false;

        // Reject repeated numbers like 00000000000, 11111111111, etc.
        if (cpf.matches("(\\d)\\1{10}")) return false;

        // CPF validation algorithm
        int sum = 0, weight = 10;

        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }

        int firstCheckDigit = 11 - (sum % 11);
        if (firstCheckDigit >= 10) firstCheckDigit = 0;

        sum = 0;
        weight = 11;

        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }

        int secondCheckDigit = 11 - (sum % 11);
        if (secondCheckDigit >= 10) secondCheckDigit = 0;

        return cpf.charAt(9) - '0' == firstCheckDigit &&
               cpf.charAt(10) - '0' == secondCheckDigit;
    }

    public static boolean validatePhone(String phone) {

        if (phone == null) return false;

       phone = phone.replaceAll("[^\\d]", "");

        // Accepts 10 or 11 digits (with or without area code)
        return phone.matches("\\d{10,11}");
    }
}

