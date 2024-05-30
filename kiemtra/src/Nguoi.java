

/**
 *
 * @author Bui Van Son
 */
public class Nguoi {
private String hoTen;
    private int tuoi;
    private String soCMND;

    

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public Nguoi(String hoTen, int tuoi, String soCMND) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soCMND = soCMND;
    }

    public Nguoi() {
    }
@Override
    public String toString() {
        return "Nguoi{" + "hoTen=" + hoTen + ", tuoi=" + tuoi + ", soCMND=" + soCMND + '}';
    }
}
