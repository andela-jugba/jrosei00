
import java.util.Collection;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class StateCapitals {

    public static void main(String[] args) {

        HashMap<String, String> state = new HashMap<>();

        state.put("Alabama", "Montgomery");

        state.put("Alaska", "Juneau");

        state.put("Arizona", "Phoenix");

        state.put("Arkansas", "Little Rock");

        System.out.println("STATE/CAPITALS PAIRS:");
        System.out.println("====================");

        Collection<String> capitals = state.values();

        for (String p  : capitals) {
            System.out.println(p);
        }
    }
}
