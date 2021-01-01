/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author yusuf
 */

    //Membatasi Karakter dengan JTextField
    //Membatasi Karakter dengan JTextField
public class JTextFieldFilter extends PlainDocument{
    private int limit;
    private String acceptedChars=null;    
    private String numeric  ="0123456789";
    private String alphabet ="abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private String alphanumeric   ="abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789- ";
   
 
    public JTextFieldFilter(int limit,int acceptedChar) {
        super();
        this.limit = limit;
        if(acceptedChar==1){
            this.acceptedChars=numeric;
        }else if(acceptedChar==2){
            this.acceptedChars=alphabet;
        }else if(acceptedChar==3){
            this.acceptedChars=alphanumeric;
        }        
    }

    public void masukinString(int offset, String str, AttributeSet attr) 
            throws BadLocationException {
        if (str == null) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
        if (acceptedChars.indexOf(String.valueOf(str.charAt(i))) == -1) {
            return;
            }
        }
        super.insertString(offset, str, attr);
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) 
            throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            masukinString(offset, str, attr);
        }
    }
}


