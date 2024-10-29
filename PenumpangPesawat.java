package semester3;

import java.util.Scanner;

public class PenumpangPesawat {
    class Passenger {
        String name;
        Passenger next;

        Passenger(String name) {
            this.name = name;
        }
    }

    class Flight {
        private Passenger head;

        public void addPassenger(String name) {
            Passenger newPassenger = new Passenger(name);
            if (head == null) {
                head = newPassenger;
            } else {
                Passenger current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newPassenger;
            }
            System.out.println("Penumpang " + name + " ditambahkan.");
        }

        public void removePassenger(String name) {
            if (head == null) return;

            if (head.name.equals(name)) {
                head = head.next;
                System.out.println("Penumpang " + name + " dihapus.");
                return;
            }

            Passenger current = head;
            while (current.next != null && !current.next.name.equals(name)) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                System.out.println("Penumpang " + name + " dihapus.");
            } else {
                System.out.println("Penumpang " + name + " tidak ditemukan.");
            }
        }

        public void displayPassengers() {
            if (head == null) {
                System.out.println("Daftar penumpang kosong.");
                return;
            }
            System.out.println("Daftar Penumpang:");
            for (Passenger current = head; current != null; current = current.next) {
                System.out.println(current.name);
            }
        }
    }

    public static void main(String[] args) {
        PenumpangPesawat app = new PenumpangPesawat();
        Flight flight = app.new Flight();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Masukkan perintah (add/remove/display/exit): ");
        while (!(command = scanner.nextLine()).equalsIgnoreCase("exit")) {
            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Nama penumpang: ");
                    flight.addPassenger(scanner.nextLine());
                    break;
                case "remove":
                    System.out.print("Nama penumpang untuk dihapus: ");
                    flight.removePassenger(scanner.nextLine());
                    break;
                case "display":
                    flight.displayPassengers();
                    break;
                default:
                    System.out.println("Perintah tidak dikenali.");
                    break;
            }
        }
        scanner.close();
    }
}
