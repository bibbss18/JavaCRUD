package ro.javacrud.pojo;

public class Produs {
    private int id;
    private String nume;
    private String categorie;
    private double pret;

    public Produs(int id, String nume, String categorie, double pret) {
        this.id = id;
        this.nume = nume;
        this.categorie = categorie;
        this.pret = pret;
    }

    public Produs(String nume, String categorie, double pret) {
        this.nume = nume;
        this.categorie = categorie;
        this.pret = pret;
    }

    public int getId() { return id; }
    public String getNume() { return nume; }
    public String getCategorie() { return categorie; }
    public double getPret() { return pret; }

    public void setId(int id) { this.id = id; }
    public void setNume(String nume) { this.nume = nume; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public void setPret(double pret) { this.pret = pret; }

    @Override
    public String toString() {
        return "Produs [id=" + id + ", nume=" + nume + ", categorie=" + categorie + ", pret=" + pret + "]";
    }
}
