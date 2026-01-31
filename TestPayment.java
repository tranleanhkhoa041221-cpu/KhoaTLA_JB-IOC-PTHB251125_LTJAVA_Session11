package BaiTapKha2;

public class TestPayment {
    public static void main(String[] args) {
        Payment[] payments = new Payment[] {
                new CashPayment(100.0),
                new CreditCardPayment(250.5, "4111-xxxx-xxxx-1111"),
                new EWalletPayment(75.25, "wallet_abc123") };
        for (Payment p : payments) {
            p.printAmount(); p.pay();
            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            }
            System.out.println("---"); } }
}
