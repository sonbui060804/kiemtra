import java.util.ArrayList; 
import java.util.List; 
import java.util.Iterator; 

// Lop KhachSan de quan ly khach thue
public class KhachSan {
    private List<KhachThue> khachThueList; // Khai bao danh sach khach thue

    public KhachSan() {
        this.khachThueList = new ArrayList<>(); // Khoi tao danh sach khach thue
    }

    // Phuong thuc them khach thue
    public void themKhachThue(KhachThue khachThue) {
        khachThueList.add(khachThue); // Them khach thue vao danh sach
    }

    // Phuong thuc xoa khach thue theo so CMND
    public void xoaKhachThue(String soCMND) {
        Iterator<KhachThue> iterator = khachThueList.iterator(); // Khoi tao iterator
        while (iterator.hasNext()) { // Lap qua danh sach khach thue
            KhachThue khachThue = iterator.next(); // Lay khach thue
            if (khachThue.getNguoi().getSoCMND().equals(soCMND)) { // Neu so CMND khop
                iterator.remove(); // Xoa khach thue khoi danh sach
                break; // Thoat khoi vong lap
            }
        }
    }

    // Phuong thuc tinh tien thue phong theo so CMND
    public double tinhTienThuePhong(String soCMND) {
        for (KhachThue khachthue : khachThueList) { // Lap qua danh sach khach thue
            if (khachthue.getNguoi().getSoCMND().equals(soCMND)) { // Neu so CMND khop
                int songaythue = khachthue.getSoNgayThue(); // Lay so ngay thue
                String loaiPhong = khachthue.getLoaiPhong(); // Lay loai phong
                double giaphong = 0; // Khoi tao bien gia phong
                
                // Xac dinh gia phong dua tren loai phong
                switch (loaiPhong) {
                    case "A":
                        giaphong = 500; 
                        break;
                    case "B":
                        giaphong = 300;
                        break;
                    case "C":
                        giaphong = 100; 
                        break;
                }
                return songaythue * giaphong; // Tinh va tra ve tien thue phong
            }
        }
        return 0; // Neu khong tim thay khach thue, tra ve 0
    }

    // Lop con KhachThue de quan ly thong tin khach thue
    public static class KhachThue {
        private Nguoi nguoi; // Khai bao thuoc tinh nguoi thue
        private int soNgayThue; // Khai bao thuoc tinh so ngay thue
        private String loaiPhong; // Khai bao thuoc tinh loai phong

        public KhachThue(Nguoi nguoi, int soNgayThue, String loaiPhong) {
            this.nguoi = nguoi; // Gan gia tri cho thuoc tinh nguoi thue
            this.soNgayThue = soNgayThue; // Gan gia tri cho thuoc tinh so ngay thue
            this.loaiPhong = loaiPhong; // Gan gia tri cho thuoc tinh loai phong
        }

        public Nguoi getNguoi() {
            return nguoi; // Lay gia tri thuoc tinh nguoi thue
        }

        public void setNguoi(Nguoi nguoi) {
            this.nguoi = nguoi; // Dat gia tri cho thuoc tinh nguoi thue
        }

        public int getSoNgayThue() {
            return soNgayThue; // Lay gia tri thuoc tinh so ngay thue
        }

        public void setSoNgayThue(int soNgayThue) {
            this.soNgayThue = soNgayThue; // Dat gia tri cho thuoc tinh so ngay thue
        }

        public String getLoaiPhong() {
            return loaiPhong; // Lay gia tri thuoc tinh loai phong
        }

        public void setLoaiPhong(String loaiPhong) {
            this.loaiPhong = loaiPhong; // Dat gia tri cho thuoc tinh loai phong
        }
    }

    public static void main(String[] args) {
        KhachSan khachSan = new KhachSan(); // Tao doi tuong KhachSan

        // Tao doi tuong Nguoi va KhachThue
        Nguoi nguoi1 = new Nguoi("Nguyen Van A", 30, "1234567890"); // Tao doi tuong Nguoi
        KhachThue khachThue1 = new KhachThue(nguoi1, 1000545, "A"); // Tao doi tuong KhachThue
        khachSan.themKhachThue(khachThue1); // Them khach thue vao danh sach

        Nguoi nguoi2 = new Nguoi("Tran Thi B", 25, "0123456789"); // Tao doi tuong Nguoi
        KhachThue khachThue2 = new KhachThue(nguoi2, 300222, "C"); // Tao doi tuong KhachThue
        khachSan.themKhachThue(khachThue2); // Them khach thue vao danh sach
        
        Nguoi nguoi3 = new Nguoi("Nguyen Van C", 30, "12345678910"); // Tao doi tuong Nguoi
        KhachThue khachThue3 = new KhachThue(nguoi3, 5000000, "A"); // Tao doi tuong KhachThue
        khachSan.themKhachThue(khachThue3); // Them khach thue vao danh sach
        
        // Tinh va in tien thue phong cua khach
        System.out.println("Tien thue phong cua khach 1: " + khachSan.tinhTienThuePhong("1234567890")); // Tinh va in tien thue phong khach 1
        System.out.println("Tien thue phong cua khach 2: " + khachSan.tinhTienThuePhong("0123456789")); // Tinh va in tien thue phong khach 2
        System.out.println("Tien thue phong cua khach 3: " + khachSan.tinhTienThuePhong("12345678910")); // Tinh va in tien thue phong khach 3
        
        khachSan.xoaKhachThue("1234567890"); // Xoa khach thue 1

        // Tinh va in tien thue phong cua khach sau khi xoa
        System.out.println("Tien thue phong cua khach 1 sau khi xoa: " + khachSan.tinhTienThuePhong("1234567890")); // Tinh va in tien thue phong khach 1 sau khi xoa
    }
}
