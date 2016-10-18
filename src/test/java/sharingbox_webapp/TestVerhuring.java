package sharingbox_webapp;

/**
 * Created by martialh on 10/18/16.
 */
public class TestVerhuring {
    private String status;
    public TestVerhuring() {
        this.status = "Aanvraag";
    }

    public String GetStatus() {
      return  this.status;
    }
    public void VerhuringToevoegen() {
        this.status = "In behandeling";
    }

    public void VerhuringAnnuleren() {
        this.status = "Geannuleerd";
    }

    public void VerhuringOpheffen() {
        this.status = "In behandeling";
    }
}
