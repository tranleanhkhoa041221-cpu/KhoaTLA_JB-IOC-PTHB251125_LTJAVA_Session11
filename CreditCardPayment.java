package BaiTapKha2;

import BaiTapKha1.Drawable;

public class CreditCardPayment extends Payment implements Refundable {
    private String cardNumber;
    public  CreditCardPayment() {
    }
    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán bằng thẻ tín dụng (" + getCardNumber() + "): " + getAmount());

    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền cho thẻ tín dụng (" + getCardNumber() + "): " + getAmount());

    }
}
