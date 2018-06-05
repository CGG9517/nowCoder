package interveiw;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

class Human {
    public String tryCatch(){
        String str;
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
//            System.out.println("Caught Sneeze");
            str = "Caught Sneeze";
            return str;
        }
        finally {
//            System.out.println("Hello World!");
            str = "hello world";
        }
    }

    public static void main(String[] args)
            throws Exception {
        System.out.println(new Human().tryCatch());
    }
}