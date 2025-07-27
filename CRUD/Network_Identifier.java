import java.util.*;

public class Network_Identifier {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Network Identifier!\n");
        System.out.print("Enter your 11 Digit number: ");
        String input = in.next();

        final String[] globe = {
            "0817", "0905", "0906", "0915", "0916", "0917",
            "0925", "0926", "0927", "0935", "0936", "0937",
            "0945", "0953", "0954", "0955", "0956", "0966",
            "0967", "0975", "0977", "0978", "0979", "0994",
            "0995", "0996", "0997"
        };

        final String[] smart = {
            "0813", "0900", "0907", "0908", "0909",
            "0910", "0911", "0912", "0913", "0914",
            "0918", "0919", "0920", "0921", "0928",
            "0929", "0930", "0938", "0939", "0946",
            "0947", "0948", "0949", "0950", "0951",
            "0961", "0968", "0969", "0989", "0998", "0999"
        };

        // yung "\\d{11}" vinavalidate nya if nagcocointain ba ng 11 digit yung input 
        if (!input.matches("\\d{11}")) {
            System.out.println("Invalid input! Please enter exactly 11 digits with no letters or symbols.");
            return;
        }

        //ge-get neto yung first 4 digit ng number na ininput para malaman saang network sya nag fafall
        String prefix = input.substring(0, 4);


        if (Arrays.asList(globe).contains(prefix)) {
            System.out.println("Your number is under the GLOBE network.");
        } else if (Arrays.asList(smart).contains(prefix)) {
            System.out.println("Your number is under the SMART network.");
        } else {
            System.out.println("Invalid network prefix. Please check your number.");
        }
    }
}
