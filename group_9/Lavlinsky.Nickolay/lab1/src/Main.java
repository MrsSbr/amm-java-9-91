import java.util.Scanner;
public class Main

{
    public static void main(String[] args) {
        System.out.println("Input size of array:");
        Scanner scan = new Scanner(System.in);
        int[] arr=new int [scan.nextInt()];
        for ( int i = 0; i < arr.length; i++)
        {
            System.out.println("Input your number:");
            arr[i]=scan.nextInt();
        }
        for (int i = 0; i < arr.length; i++ )
        {
            for (int j = 0; j < arr.length; j++ )
            {
                if(arr[i]==arr[j])
                {
                    System.out.println("true");
                    return ;
                }

            }
        }
        System.out.println("false");
        return ;
    }
}