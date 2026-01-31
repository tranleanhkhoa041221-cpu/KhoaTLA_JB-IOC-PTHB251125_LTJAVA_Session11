package BaiTapKha2;

public class EWalletPayment extends Payment implements Refundable {
    private String walletId;

    public EWalletPayment() {
    }

    public EWalletPayment(double amount, String walletId) {
        super(amount);
        this.walletId = walletId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán bằng ví điện tử (" + getWalletId() + "): " + getAmount());

    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền cho ví điện tử (" + getWalletId() + "): " + getAmount());


    }
}
