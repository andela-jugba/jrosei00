/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class ClassActivity {
    

}

interface IHasWings {
    public void FlapWings();
}

// In order for IHasWings to connect with ICanFly
interface ICanFly extends IHasWings {
    public void Fly();
}

//In its own brackets, since Penguin is connected with IHasWings, it is connected with Fly
class Penguin implements IHasWings {
    
    @Override
    public void FlapWings(){
        System.out.println("Flappity");
    }
}  

class Sparrow implements ICanFly {
    
    @Override
    public void FlapWings(){
        System.out.println("Flap Again");
    }
    public void Fly() {
        
    }
}
    

