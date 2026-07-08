package app;

public class EmailProviderParser {
    public static void main(String[] args) {
        EmailProviderParser email = new EmailProviderParser();
        email.checkEmails("ya@yahoo.com; on@mail.ru; ona@gmail.com;ona@yahhyo.com;  on@mail.ru;");
    }

    public void checkEmails(String emailsList) {
        if (emailsList.length() == 0) {
            return;
        }

        int count = 0;
        while (count < emailsList.length()) {
            String substring = emailsList.substring(count, emailsList.indexOf(';', count) + 1);
            int startIndex = substring.indexOf('@') + 1;
            int endIndex =  substring.indexOf('.');

            for (int i = 0; i <= substring.length(); i++) {

                if (i >= startIndex && i < endIndex ) {
                    System.out.print(substring.charAt(i));
                    continue;
                }

                if (i == substring.length()) {
                    System.out.println();
                    count += substring.length() + 1;
                }
            }
        }
    }
}

/*
Practice Task: Email Provider Parser

Create a Java class that contains a method named email.

Requirements
The email method must accept one String parameter.
The input string contains multiple email addresses separated by semicolons (;).

Example input:

ya@yahoo.com;on@mail.ru;ona@gmail.com;
Your task

For each email address:

Extract the email provider (the domain name between @ and the first .).
Print the provider name on a separate line.

Expected output:

yahoo
mail
gmail

Notes
Assume the input string is correctly formatted.
Every email address ends with a semicolon (;).
Demonstrate your method by calling it from the main method with a sample input.
 */
