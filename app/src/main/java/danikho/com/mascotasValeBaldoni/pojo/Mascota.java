package danikho.com.mascotasValeBaldoni.pojo;

public class Mascota {
    private String nombre, rating;
    private int id, foto;

    public Mascota(int id, int foto, String nombre, String rating) {

        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.rating = rating;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }


    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
