/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class VendingMachineIOImpl implements VendingMachineIO {
    
    Scanner kb = new Scanner(System.in);

    public int readInt(String p) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    public int readInt(String p, int min, int max) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);

        return ret;
    }

    public long readLong(String p) {
        boolean failed;
        long ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    public long readLong(String p, long min, long max) {
        boolean failed;
        long ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextLong();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);

        return ret;
    }

    public String readString(String p) {
        System.out.print(p);
        return kb.nextLine();
    }

    public float readFloat(String p) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    public float readFloat(String p, float min, float max) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);

        return ret;
    }

    public double readDouble(String p) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    public double readDouble(String p, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);

        return ret;
    }

    public void print(String p) {
        System.out.println(p);
    }
}
