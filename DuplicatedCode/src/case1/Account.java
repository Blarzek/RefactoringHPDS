package case1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Account {

    private List<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public LocalDate getLastTransactionDate() {
        return transactions.isEmpty() ?
                null :
                transactions.stream().max(transactionDate()).get().getDate();
    }

    private Comparator<Transaction> transactionDate() {
        return (t1, t2) -> t1.getDate().compareTo(t2.getDate());
    }

    public void credit(double amount) {
        transactions.add(new Transaction(LocalDate.now(), -amount));
    }

    public void debit(double amount) {
        transactions.add(new Transaction(LocalDate.now(), amount));
    }

}
