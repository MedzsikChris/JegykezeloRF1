package application.model;


public class Vonatkeses {



    int vonat_id;
    int mennyit;

    String honnan;

    String hova;

   public Vonatkeses() {}

    public Vonatkeses(int vonat_id, int mennyit, String honnan, String hova) {
        this.vonat_id = vonat_id;
        this.mennyit = mennyit;
        this.honnan = honnan;
        this.hova = hova;
    }

    public int getVonat_id() {
        return vonat_id;
    }

    public void setVonat_id(int vonat_id) {
        this.vonat_id = vonat_id;
    }

    public int getMennyit() {
        return mennyit;
    }

    public void setMennyit(int mennyit) {
        this.mennyit = mennyit;
    }

    public String getHonnan() {
        return honnan;
    }

    public void setHonnan(String honnan) {
        this.honnan = honnan;
    }

    public String getHova() {
        return hova;
    }

    public void setHova(String hova) {
        this.hova = hova;
    }

    @Override
    public String toString() {
        return "vonatkeses{" +
                "id=" + vonat_id +
                ", mennyit='" + mennyit + '\'' +
               '}';
    }
}
