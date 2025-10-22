package ro.javacrud.pojo;

public class Client {
    private int id;
    private String nume;
    private String adresa;
    private String telefon;

    public Client(int id, String nume, String adresa, String telefon) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Client(String nume, String adresa, String telefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getId() { return id; }
    public String getNume() { return nume; }
    public String getAdresa() { return adresa; }
    public String getTelefon() { return telefon; }

    public void setId(int id) { this.id = id; }
    public void setNume(String nume) { this.nume = nume; }
    public void setAdresa(String adresa) { this.adresa = adresa; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    @Override
    public String toString() {
        return "Client [id=" + id + ", nume=" + nume + ", adresa=" + adresa + ", telefon=" + telefon + "]";
    }
}
