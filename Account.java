package Account;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Account {
    private String name ="" ;
    private long money;
    private long balance;
    private String [] arr_action = new  String [3] ;
    private  long [] arr_money = new long[3];

    public Account(){};

    public Account(String name , long money){
        this.name = name ;
        this.money = money ;
    }

    public String getName(){ return this.name ; }

    public long getMoney(){return  this.money ;}

    public void depositMoney(long money) {
        this.money += money ;
        for (int i = 2; i > 0 ; i --){
            this.arr_action[i] = this.arr_action[i-1] ;
            this.arr_money[i] = this.arr_money[i-1];
        }
        this.arr_action [0] = "Nap tien";
        this.arr_money [0] = money;
    }

    public void withdrawMoney(long money) {
        this.money -= money ;
        for (int i = 2; i > 0 ; i --){
            this.arr_action[i] = this.arr_action[i-1] ;
            this.arr_money[i] = this.arr_money[i-1];
        }
        this.arr_action [0] = "Rut tien";
        this.arr_money [0] = money;
    }

    public void transactionHistory(){
        String str ="";
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        for (int i =0 ; i < this.arr_action.length ; i++){
            str += " " + (i+1) + ". " + this.arr_action[i] +": "+ formatter.format(this.arr_money[i]) + " VND\n";
        }
        System.out.println(str);
    }

    public void showMenu() {
        Scanner scanner;
        char choice = 0;

        System.out.println("\nNgân hàng ABC kính chào Quý khách " + name);
        System.out.println("\nMenu");
        System.out.println("\n1. Nhấn phím A để kiểm tra tài khoản");
        System.out.println("\n2. Nhấn phím D để nạp tiền (Quý khách vui lòng nhập số tiền theo VNĐ)");
        System.out.println("\n3. Nhấn phím W để rút tiền (Quý khách vui lòng nhập số tiền theo VNĐ)");
        System.out.println("\n4. Nhấn phím H để xem lịch sử 3 lần");
        System.out.println("\n5. Nhấn phím X để thoát");
        System.out.println("\n====================================");

        do {
        System.out.println("\nNhập lựa chọn của bạn: ");
        scanner = new Scanner(System.in);
        choice = scanner.nextLine().charAt(0);
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            switch(choice) {
                case 'A':
                case 'a':
                    System.out.println("\nSố dư tài khoản khách hàng là " + formatter.format(getMoney()));
                    System.out.println("\nBấm nút theo menu để tiếp tục giao dịch ");
                    System.out.println("\n====================================");
                    break;
                case 'D' :
                case 'd':
                    System.out.println("\nGiao dịch nạp tiền: ");
                    System.out.println("\nVui lòng nhập số tiền: ");
                    long amount1 = scanner.nextLong();
                    depositMoney(amount1);
                    System.out.println("Giao dịch thành công. Bạn vừa nạp " + formatter.format(amount1) + " VNĐ" + " thành công.");
                    System.out.println("\nSố dư tài khoản khách hàng là: " + formatter.format(getMoney()) + " VNĐ.");
                    break;
                case 'W':
                case 'w':
                    System.out.println("\nGiao dịch rút tiền: ");
                    System.out.println("\nVui lòng nhập số tiền: ");
                    long amount2 = scanner.nextLong();
                    if (amount2 <= money) {
                        withdrawMoney(amount2);
                        System.out.println("\nGiao dịch thành công. Bạn vừa rút " + formatter.format(amount2) + " VNĐ" + " thành công.");
                        System.out.println("\nSố dư tài khoản khách hàng là: " + formatter.format(getMoney()) + " VNĐ.");
                    } else {
                        System.out.println("\nGiao dịch không thành công.");
                        System.out.println("\nSố dư tài khoản khách hàng là: " + formatter.format(getMoney()) + " VNĐ.");
                        System.out.println("\nBạn không thể rút số tiền lớn hơn số dư tài khoản.");
                        System.out.println("\nBấm nút menu để tiếp tục giao dịch.");
                    }
                    break;
                case 'H':
                case 'h':
                    System.out.println("\nLịch sử giao dịch:");
                    transactionHistory();
                    break;
                case 'X':
                case 'x':
                    System.out.println("\nCảm ơn bạn đã sử dụng dịch vụ ATM!");
                    break;
                default:
                    System.out.println("Bạn nhập sai chức năng.");
                    System.out.println("Bấm nút theo menu để tiếp tục giao dịch.");
                    System.out.println("\n====================================");
                    break;
            }
        } while((choice != 'X') && (choice != 'x'));
    }
}
