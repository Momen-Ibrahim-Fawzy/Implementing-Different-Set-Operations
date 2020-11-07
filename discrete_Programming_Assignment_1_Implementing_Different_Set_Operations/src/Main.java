import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        SetAssignment setAssignmentApp =new SetAssignment();
        String universe;
        System.out.println("please enter the universe set of strings:");
        String s="";
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        universe=s;
        System.out.println("please enter the number of subsets of the universe:");
        int n;
        n=scanner.nextInt();
        setAssignmentApp.ReadSetsAndStoreThem(n,universe);
        boolean execute=true;
        while (execute) {
            System.out.println("please enter the operation that you want as:");
            System.out.println("1:Union of two sets\n2:Intersection of two sets\n3:Complement of a set");
            System.out.println("Or enter \n0:to end program");
            n = scanner.nextInt();
            if (n==0){
                System.out.println("END");
                System.exit(0);
            }
            else if(n==1||n==2||n==3){
                setAssignmentApp.execution(n);
            }
            else {
                System.out.println("not valid choice");
                System.out.println("please enter the operation that you want as:");
                System.out.println("1:Union of two sets\n2:Intersection of two sets\n3:Complement of a set");
                System.out.println("Or enter \n0:to end program");
            }
        }
    }
}
