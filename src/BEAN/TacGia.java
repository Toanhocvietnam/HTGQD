package BEAN;

public class TacGia implements java.lang.Comparable<TacGia> {
	private String id;
	private String email;
	private String hoTen;
	private String password;
	private int soBanBeChung;
	private int soBaiBaoVietChung;
	private int soBaiBaoVeLinhVuc;
	private float soBanBeChungCH;
	private float soBaiBaoVietChungCH;
	private float soBaiBaoVeLinhVucCH;
	private double kcLyTuongTot;
	private double kcLyTuongXau;
	private double doDoGiaiPhapLyTuong;
	
	public TacGia(String id, String email, String hoTen, String password) {
		super();
		this.id = id;
		this.email = email;
		this.hoTen = hoTen;
		this.password = password;
	}
	public TacGia(String email) {
		super();
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSoBanBeChung() {
		return soBanBeChung;
	}
	public void setSoBanBeChung(int soBanBeChung) {
		this.soBanBeChung = soBanBeChung;
	}
	public int getSoBaiBaoVietChung() {
		return soBaiBaoVietChung;
	}
	public void setSoBaiBaoVietChung(int soBaiBaoVietChung) {
		this.soBaiBaoVietChung = soBaiBaoVietChung;
	}
	public int getSoBaiBaoVeLinhVuc() {
		return this.soBaiBaoVeLinhVuc;
	}
	public void setSoBaiBaoVeLinhVuc(int soBaiBaoVeLinhVuc) {
		this.soBaiBaoVeLinhVuc = soBaiBaoVeLinhVuc;
	}
	
	public float getSoBanBeChungCH() {
		return soBanBeChungCH;
	}
	public float getSoBaiBaoVietChungCH() {
		return soBaiBaoVietChungCH;
	}
	public float getSoBaiBaoVeLinhVucCH() {
		return soBaiBaoVeLinhVucCH;
	}
	
	public double getDoDoGiaiPhapLyTuong() {
		return doDoGiaiPhapLyTuong;
	}
	
	public double getKcLyTuongTot() {
		return kcLyTuongTot;
	}
	public double getKcLyTuongXau() {
		return kcLyTuongXau;
	}
	public void chuanHoa(int maxSoBanBeChung,int maxSoBaiVietChung,int maxSoBaiCungLinhVuc) {
		this.soBanBeChungCH = (float)Math.round(((float)this.soBanBeChung* 0.2/maxSoBanBeChung)*10000)/10000;
		this.soBaiBaoVietChungCH =(float)Math.round(((float)this.soBaiBaoVietChung* 0.4/maxSoBaiVietChung)*10000)/10000;
		this.soBaiBaoVeLinhVucCH =(float)Math.round(((float)this.soBaiBaoVeLinhVuc* 0.4/maxSoBaiCungLinhVuc)*10000)/10000;
	}
	public void tinhKcLyTuongTot(float soBanBeChungLTT, float soBaiVietChungLTT, float soBaiCungLinhVucLTT) {
		this.kcLyTuongTot=
				Math.sqrt(
				Math.pow(this.soBanBeChungCH - soBanBeChungLTT, 2) + Math.pow(this.soBaiBaoVietChungCH - soBaiVietChungLTT, 2)
				+Math.pow(this.soBaiBaoVeLinhVucCH - soBaiCungLinhVucLTT, 2)
				
				
				);
	}
	public void tinhKcLyTuongXau(float soBanBeChungLTX, float soBaiVietChungLTX, float soBaiCungLinhVucLTX) {
		this.kcLyTuongXau=
				Math.sqrt(
				Math.pow(this.soBanBeChungCH - soBanBeChungLTX, 2) +Math.pow(this.soBaiBaoVietChungCH - soBaiVietChungLTX, 2)
				+Math.pow(this.soBaiBaoVeLinhVucCH - soBaiCungLinhVucLTX, 2)
				
				
				);
	}
	public void tinhDoDoTuongTuGiaiPhapLT() {
		this.doDoGiaiPhapLyTuong = (double)Math.round((kcLyTuongXau/(kcLyTuongTot+kcLyTuongXau))*10000)/10000;
	}
	
	 public int compareTo(TacGia tg) {
		 if (this.doDoGiaiPhapLyTuong == tg.getDoDoGiaiPhapLyTuong())
				return 0;
			else if (this.doDoGiaiPhapLyTuong > tg.getDoDoGiaiPhapLyTuong())
				return 1;
			else
				return -1;
	  
	 }
	
}
