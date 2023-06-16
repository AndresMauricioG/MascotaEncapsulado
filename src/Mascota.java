import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mascota {
    private int codigo;
    private String nombre;
    private String especie;
    private int edad;
    private String edadString;
    private ArrayList<String> informacionMascota;

    public Mascota() {
        nombre = "Firu";
        especie = "Default";
        edad = 0;
        informacionMascota = new ArrayList<>();
    }

    public void ingresar() {
        String val;

        do {
            nombre = JOptionPane.showInputDialog("Ingrese nombre");
            especie = JOptionPane.showInputDialog("Ingrese la especie de " + nombre);
            edad = Integer.parseInt(JOptionPane.showInputDialog("Edad de la mascota " + nombre));

            informacionMascota.add(nombre);
            informacionMascota.add(especie);
            edadString = Integer.toString(edad);
            informacionMascota.add(edadString);

            val = JOptionPane.showInputDialog("¿Desea ingresar otra?");
        } while (val.equalsIgnoreCase("SI"));
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    public void mostrarInformacionGeneral() {
        for (int i = 0; i < informacionMascota.size(); i++) {
            System.out.println(informacionMascota.get(i));
        }
    }

    public void consultaIndividual() {
        if (informacionMascota.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a consultar");
        boolean encontrada = false;

        for (int i = 0; i < informacionMascota.size(); i += 3) {
            String nombre = informacionMascota.get(i);

            if (nombre.equalsIgnoreCase(nombreBuscado)) {
                String especie = informacionMascota.get(i + 1);
                String edadString = informacionMascota.get(i + 2);
                int edad = Integer.parseInt(edadString);

                Mascota mascotaConsultada = new Mascota(nombre, especie, edad);
                mascotaConsultada.mostrarInformacion();
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La mascota no se encontró en la lista.");
        }
    }

    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
}

