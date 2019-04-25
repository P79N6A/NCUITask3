package com.netcracker.client.validator;

public class Validator implements ValidatorLibrary {
    public static String bookValidator(String authorName,
                                     String authorGender,
                                     String authorEmail,
                                     String bookName,
                                     String bookKolStr,
                                     String bookDateIsd,
                                     String bookDateAdd) {
        String result = "";
        result += ValidatorLibrary.authorFullNameValidator(authorName);
        result += ValidatorLibrary.authorSexValidator(authorGender);
        result += ValidatorLibrary.authorEmailValidator(authorEmail);
        result += ValidatorLibrary.bookNameValidator(bookName);
        result += ValidatorLibrary.bookKolStrValidator(bookKolStr);
        result += ValidatorLibrary.bookDateIsdValidator(bookDateIsd);
        result += ValidatorLibrary.bookDateAddValidator(bookDateAdd);
        if (!result.equals(""))
            return "Invalid: " + result.substring(0, result.length() - 1);
        else return "Success";
    }
}
