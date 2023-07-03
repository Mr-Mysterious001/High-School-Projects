/*This is my first java project. This a password generator and checker which can help u create a random password and check if ur password is strong or weak.
Again this is not my original idea. I have taken inspiration from https://github.com/KZarzour/Password-Generator  */


import java.util.*;
import java.io.Console;
public class pass_gen {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        pass_gen ob = new pass_gen();
        Console cns=System.console();
        System.out.println("Welcome to Password Generator and checker");
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        int c = in.nextInt();
        switch (c) {
            case 1:
                String gen_pass=ob.passgen();
                System.out.println(gen_pass);
                break;
            case 2:
                String passString="";
                System.out.println("Enter your password");
                char[] ch=cns.readPassword();
                for(int i=0;i<ch.length;i++)
                {
                    passString=passString+ch[i];
                }
                ob.chkPass(passString);
                break;
            case 3:
                ob.useinfo();
            case 4:
                ob.quitmsg();
                break;
            default:
                System.out.println("that is not a choice");
                break;
        }
    }

    String passgen() {
        int sc = 0;
        int i=1;
        System.out.println("Enter the required length of password");
        int l = in.nextInt();
        char u,lc,splch,dig;
        String p = "";
        System.out.println("do u want upper case letters?(y/n)");
        u=in.next().charAt(0);
        System.out.println("do u want lower case letters?(y/n)");
        lc=in.next().charAt(0);
        System.out.println("do u want special characters?(y/n)");
        splch=in.next().charAt(0);
        System.out.println("do u want numbers?(y/n)");
        dig=in.next().charAt(0);
        while(i <= l){
            sc = (int)(Math.random() * 4) + 1;
            if(u=='n'&&sc==1) continue;
            if(lc=='n'&&sc==2) continue;
            if(dig=='n'&&sc==3) continue;
            if(splch=='n'&&sc==4) continue;
            switch (sc) {
                case 1:
                    p = p + (char) ((int) (Math.random() * 26) + 65);
                    break;
                case 2:
                    p = p + (char) ((int) (Math.random() * 26) + 97);
                    break;
                case 3:
                    p = p + (char) ((int) (Math.random() * 10) + 48);
                    break;
                case 4:
                    p = p + (char) ((int) (Math.random() * 16) + 32);
                }
            i++;
            }
        return (p);
    }

    void chkPass(String p)
    {
        int l=0,uc=0,d=0,sc=0,lc=0;
        for(int i=0;i<p.length();i++)
        {
            char ch=p.charAt(i);
            if(chkUpper(ch)) uc++;
            if(chkLower(ch)) lc++;
            if(chkDigit(ch)) d++;
            if(chkSplChar(ch)) sc++;
        }
        if(p.length()<=7) l++;
        if(p.length()>7&&p.length()<=10) l++;
        if(p.length()>10&&p.length()<=13) l++;
        if(p.length()>13) l++;
        if(l==1&&uc>0&&lc>0&&d>0&&sc>0) System.out.println("Very Weak Password");
        else if(l==2&&uc>0&&lc>0&&d>0&&sc>0) System.out.println("Weak Password");
        else if(l==3&&uc>0&&lc>0&&d>0&&sc>0) System.out.println("Good Password");
        else if(l==4&&uc>0&&lc>0&&d>0&&sc>0) System.out.println("Strong Password");
        else System.out.println("Weak Password");
    }
    boolean chkUpper(char pass)
    {
        if(Character.isUpperCase(pass))
        return true;
        return false;
    }
    
    boolean chkLower(char pass)
    {
        if(Character.isLowerCase(pass))
        return true;
        return false;
    }
    
    boolean chkDigit(char pass)
    {
        if(Character.isDigit(pass))
        return true;
        return false;
    }
    
    boolean chkSplChar(char pass)
    {
        if(!Character.isLetter(pass)&&!Character.isDigit(pass)&&!Character.isWhitespace(pass))
        return true;
        return false;
    }
    
    void useinfo()
    {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }
    
    void quitmsg()
    {
        System.out.println("The application will now end,");
    }
}
