/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
        Fairy fairy = Fairy.create();
        Person p = fairy.person();
        System.out.println(p.getFullName());
        System.out.println(p.getCompanyEmail());
        
        TextProducer text = Fairy.create().textProducer();
        System.out.println(text.sentence());
        
        System.out.println(text.paragraph(3));

    }
}
