String decimalToBinary(String num) {    
    if (Integer.valueOf(num) == 0) {
        return num;
    }

    int number = Integer.valueOf(num);
    char[] binary = new char[32];

    int index = 0, remainder;
    while (number > 0) {
        remainder = number % 2;
        binary[index] = (char) (remainder + '0');
        number /= 2;
        index++;
    }

    char[] revbinary = new char[index];
    for (int i = 0; i < index; i++) {
        revbinary[i] = binary[index - i - 1];
    }
    String result = String.valueOf(revbinary);

    return result;
}

String decimalToOctal(String num) {    
    if (Integer.valueOf(num) == 0) {
        return num;
    }

    int number = Integer.valueOf(num);
    char[] octal = new char[32];

    int index = 0, remainder;
    while (number > 0) {
        remainder = number % 8;
        octal[index] = (char) (remainder + '0');
        number /= 8;
        index++;
    }

    char[] revoctal = new char[index];
    for (int i = 0; i < index; i++) {
        revoctal[i] = octal[index - i - 1];
    }
    String result = String.valueOf(revoctal);

    return result;
}

String decimalToHexadecimal(String num) {    
    if (Integer.valueOf(num) == 0) {
        return num;
    }

    int number = Integer.valueOf(num);
    char[] hexa = new char[32];

    int index = 0, remainder;
    while (number > 0) {
        remainder = number % 16;
        if (remainder > 9) {
            hexa[index] = (char) (remainder + 87);
        } else {
            hexa[index] = (char) (remainder + '0');
        }
        number /= 16;
        index++;
    }

    char[] revhexa = new char[index];
    for (int i = 0; i < index; i++) {
        revhexa[i] = hexa[index - i - 1];
    }
    String result = String.valueOf(revhexa);

    return result;
}

String binaryToDecimal(String num) {
    int decimal = 0;
    int base = 1;

    for (int i = num.length() - 1; i >= 0; i--) {
        if (num.charAt(i) == '1') {
            decimal += base;
        }
        base *= 2;
    }
    String result = String.valueOf(decimal);

    return result;
}

String binaryToOctal(String num) {
    String decimal = binaryToDecimal(num);
    String result = decimalToOctal(decimal);

    return result;
}

String binaryToHexadecimal(String num) {
    String decimal = binaryToDecimal(num);
    String result = decimalToHexadecimal(decimal);

    return result;
}

String octalToDecimal(String num) {
    int decimal = 0;
    int base = 1;

    for (int i = num.length() - 1; i >= 0; i--) {
        decimal += (num.charAt(i) - '0') * base;
        base *= 8;
    }
    String result = String.valueOf(decimal);

    return result;
}

String octalToBinary(String num) {
    String decimal = octalToDecimal(num);
    String result = decimalToBinary(decimal);

    return result;
}

String octalToHexadecimal(String num) {
    String decimal = octalToDecimal(num);
    String result = decimalToHexadecimal(decimal);

    return result;
}

String hexadecimalToDecimal(String num) {
    int decimal = 0;
    int base = 1;

    for (int i = num.length() - 1; i >= 0; i--) {
        char ch = num.charAt(i);
        int value = 0;
        if (ch >= '0' && ch <= '9') {
            value = ch - '0';
        } else if (ch >= 'a' && ch <= 'f') {
            value = ch - 87;
        } else if (ch >= 'A' && ch <= 'F') {
            value = ch - 55;
        }

        decimal += value * base;
        base *= 16;
    }
    String result = String.valueOf(decimal);

    return result;
}

String hexadecimalToBinary(String num) {
    String decimal = hexadecimalToDecimal(num);
    String result = decimalToBinary(decimal);

    return result;
}

String hexadecimalToOctal(String num) {
    String decimal = hexadecimalToDecimal(num);
    String result = decimalToOctal(decimal);

    return result;
}

public String toXXSystem(String num, String XX) {    
    String result = "0";
    char input = num.charAt(1);

    if (input >= 'A') {        
        num = num.substring(2);
        switch (input) {
            case 'b':
            case 'B':
                if (XX == "D" || XX == "d") {
                    result = binaryToDecimal(num);
                } else if (XX == "O" || XX == "o") {
                    result = binaryToOctal(num);
                } else if (XX == "H" || XX == "h") {
                    result = binaryToHexadecimal(num);
                } else {
                    return "Provide valid input!";
                }
                break;
            case 'x':
            case 'X':
                if (XX == "D" || XX == "d") {
                    result = hexadecimalToDecimal(num);
                } else if (XX == "O" || XX == "o") {
                    result = hexadecimalToOctal(num);
                } else if (XX == "B" || XX == "b") {
                    result = hexadecimalToBinary(num);
                } else {
                    return "Provide valid input!";
                }
                break;
            default:
                break;
        }
    } else if (num.charAt(0) == '0') {
        if (XX == "D" || XX == "d") {
            result = octalToDecimal(num);
        } else if (XX == "H" || XX == "h") {
            result = octalToHexadecimal(num);
        } else if (XX == "B" || XX == "b") {
            result = octalToBinary(num);
        } else {
            return "Provide valid input!";
        }
    } else {
        if (XX == "B" || XX == "b") {
            result = decimalToBinary(num);
        } else if (XX == "H" || XX == "h") {
            result = decimalToHexadecimal(num);
        } else if (XX == "O" || XX == "o") {
            result = decimalToOctal(num);
        } else {
            return "Provide valid input!";
        }
    }

    return result;
}

