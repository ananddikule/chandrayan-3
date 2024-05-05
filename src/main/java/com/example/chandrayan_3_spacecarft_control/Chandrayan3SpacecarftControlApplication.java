package com.example.chandrayan_3_spacecarft_control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class Chandrayan3SpacecarftControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chandrayan3SpacecarftControlApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        // Initialize spacecraft
        ChandrayanSpaceCraftControl spacecraft = initializeSpacecraft();

        // Continuous prompt for commands
        while (true) {
            System.out.print("Enter command (f, b, l, r, u, d) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Exiting...");
                break;
            }

            String[] commands = input.split("\\s+");

            spacecraft.sendCommands(commands);

            System.out.println("Current Position: (" + spacecraft.getX() + ", " +
                    spacecraft.getY() + ", " + spacecraft.getZ() + ")");
            System.out.println("Current Direction: " + spacecraft.getDirection());
        }

        scanner.close();
    }

    private static ChandrayanSpaceCraftControl initializeSpacecraft() {
        System.out.println("Initializing Chandrayan-3 with coordinate X-0, Y-0, Z-0 & Direction-N...");
        return new ChandrayanSpaceCraftControl(0, 0, 0, Direction.N);
    }
}
