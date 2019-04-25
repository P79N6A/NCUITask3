package com.netcracker.client.validator;

public interface ValidatorLibrary {
    static String bookNameValidator(String bookName) {
        if (bookName.length() == 0) {
            return "bookName,";
        }
        for(int i = 0;i<bookName.length();i++)
        {
            if(bookName.charAt(i)==' ') return "bookName,";
        }
        return "";
    }

    static String bookKolStrValidator(String bookKolStr)
    {
        if(bookKolStr.length() == 0) return "bookKolStr,";
        for(int i = 0;i<bookKolStr.length();i++)
        {
            if ((int) bookKolStr.charAt(i) > 57 || (int) bookKolStr.charAt(i) < 48) {
                return "bookKolStr,";
            }
        }
        return "";
    }

    static String bookDateIsdValidator(String bookDateIsd) {
        if (bookDateIsd.length() < 10) return "bookDateIsd,";
        for (int i = 0; i < bookDateIsd.length(); i++) {
            if (((int) bookDateIsd.charAt(i) > 57 || (int) bookDateIsd.charAt(i) < 48) && bookDateIsd.charAt(i) != '.') {
                return "bookDateIsd,";
            }
            if (bookDateIsd.charAt(i) == '.' && (i != 2 && i != 5)) {
                return "bookDateIsd,";
            }
        }
        if (bookDateIsd.charAt(2) != '.' || bookDateIsd.charAt(5) != '.') return "bookDateIsd,";
        return "";
    }

    static String bookDateAddValidator(String bookDateAdd) {
        if (bookDateAdd.length() < 10) return "bookDateAdd,";
        for (int i = 0; i < bookDateAdd.length(); i++) {
            if (((int) bookDateAdd.charAt(i) > 57 || (int) bookDateAdd.charAt(i) < 48) && bookDateAdd.charAt(i) != '.') {
                return "bookDateAdd,";
            }
            if (bookDateAdd.charAt(i) == '.' && (i != 2 && i != 5)) {
                return "bookDateAdd,";
            }
        }
        if (bookDateAdd.charAt(2) != '.' || bookDateAdd.charAt(5) != '.') return "bookDateAdd,";
        return "";
    }

    static String authorFullNameValidator(String authorFullName) {
        if (authorFullName.length() == 0) {
            return "authorName,";
        }
        for(int i = 0;i<authorFullName.length();i++)
        {
            if(authorFullName.charAt(i)==' ') return "authorName,";
        }
        return "";
    }

    static String authorSexValidator(String authorSex) {
        if (!authorSex.equals("m") && !authorSex.equals("f")) {
            return "authoGender,";
        }
        return "";
    }

    static String authorEmailValidator(String authorEmail) {
        if (authorEmail.length() == 0) return "authorEmail,";
        for(int i = 0;i<authorEmail.length();i++)
        {
            if(authorEmail.charAt(i)==' ') return "authorEmail,";
        }
        return "";
    }
}
