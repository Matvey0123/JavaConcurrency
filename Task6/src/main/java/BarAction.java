public class BarAction implements Runnable {

    Company company;

    public BarAction(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        company.showCollaborativeResult();
    }
}
