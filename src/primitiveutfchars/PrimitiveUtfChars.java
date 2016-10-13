package primitiveutfchars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveUtfChars {

    public static void main(String[] args) throws IOException {
        String cadea = "";

        File texto3 = new File("/home/oracle/NetBeansProjects/primitiveUtfChars/text3.txt");
        texto3.createNewFile();
        DataOutputStream textdout = new DataOutputStream(new FileOutputStream("texto4.txt"));
        DataInputStream textdin = new DataInputStream(new FileInputStream("texto4.txt"));
        textdout.writeUTF("esta e unha cadea\n");
        int aux1 = textdout.size();
        System.out.println("writeUTF escribiu: " + aux1);
        textdout.writeChars("esta e unha cadea\n");
        int aux2 = textdout.size();
        System.out.println("writeChars escribiu: " + (aux2 - aux1));
        textdout.writeUTF("esta e unha cadea\n");
        int aux3 = textdout.size();
        System.out.println("writeUTF escribiu: " + (aux3 - aux2));
        textdout.close();
        System.out.println("bytes totais escritos: " + textdout.size());
        System.out.println("lemos a primeira cadea en UTF: " + textdin.readUTF());
        System.out.println("numero de bytes lidos: " + aux1);
        System.out.println("Numero de bytes restantes por ler : " + textdin.available());
        System.out.println("lemos a segunda cadea en Chars: ");
        for (int i = 0; i < 18; i++) {
            cadea += textdin.readChar();
        }
        System.out.println(cadea);
        System.out.println("Numero de bytes lidos : "+(aux2-aux1));
        System.out.println("Numero de bytes restantes por ler : "+textdin.available());
        System.out.println("lemos a tercera cadea en UTF: " + textdin.readUTF());
    }

}
